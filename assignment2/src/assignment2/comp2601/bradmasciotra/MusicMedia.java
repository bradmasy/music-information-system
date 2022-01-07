package assignment2.comp2601.bradmasciotra;

import ProjectExceptions.IllegalMusicLibraryException;
import ProjectExceptions.IllegalMusicMediaException;
import ProjectInterfaces.MusicMediaInterface;
import ProjectInterfaces.MusicMediaInterfaceDoubleArgument;
import UtilityClasses.Validations;

/**
 * Represents an Music Media object.
 *
 * @author Bradley Masciotra
 * @version 1.0
 */
public abstract class MusicMedia {
	// constants

	public static final int      CURRENT_YEAR;
	public static final int      FIRST_YEAR;
	public static final String[] VALID_SKU_REFERENCES;
	public static final int      BEGINNING_INDEX_SKU_ID;
	public static final int      ENDING_INDEX_SKU_ID;
	public static final int      ILLEGAL_INTEGER;

	// instance data
	private String sku;
	private String songTitle;
	private String artist;
	private int    year;

	static {
		CURRENT_YEAR           = 2021;
		FIRST_YEAR             = 1860;
		VALID_SKU_REFERENCES   = new String[] { "vr", "af", "cd" };
		BEGINNING_INDEX_SKU_ID = 0;
		ENDING_INDEX_SKU_ID    = 2;
		ILLEGAL_INTEGER        = 0;
	}

	/**
	 * Constructor for MusicMedia.
	 */
	public MusicMedia() {
		super(); // call to the object class
	}

	/**
	 * Constructor for MusicMedia.
	 *
	 * @param sku the SKU code
	 * @param songTitle the title of the song
	 * @param artist the artist name
	 */
	public MusicMedia(final String sku, 
			          final String songTitle,
			          final String artist)
	{
		this();

		try {
			validation(sku, Validations::validateSku);
			validation(songTitle, Validations::validateString);
			validation(artist, Validations::validateString);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		this.songTitle = songTitle;
		this.artist    = artist;
		this.sku       = sku;
	}

	/**
	 * Constructor for MusicMedia.
	 * 
	 * @param sku the sku code
	 * @param songTitle the title of the song
	 * @param artist the artist name
	 * @param year the year the song was recorded
	 */
	public MusicMedia(final String sku, 
			          final String songTitle, 
			          final String artist, 
			          final int year) 
	{
		this(sku, songTitle, artist); // all validations done in previous constructor

		try {
			validation(year, Validations::validateYear);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		this.year = year;
	}

	/**
	 * Passes the string argument to the function argument as a parameter for the
	 * apply method to validate the given string.
	 *
	 * @param data the data we are passing the function to validate
	 * @param filter the function that is doing the validation
	 * @return boolean representing if the data was validated
	 */
	public static boolean validation(final String data, final MusicMediaInterface<String, Boolean> filter)
			throws IllegalMusicMediaException {
		boolean validate;

		validate = false;

		try {
			validate = filter.check(data);
		} catch (IllegalMusicLibraryException e) {
			System.out.println(e.getMessage());
		}

		return validate;
	}

	/**
	 * Passes the integer argument to the function argument as a parameter for the
	 * apply method to validate the given integer.
	 *
	 * @param data the data we are passing the function to validate
	 * @param filter the function that is doing the validation
	 * @return boolean representing if the data was validated
	 */
	public static boolean validation(final int data, final MusicMediaInterface<Integer, Boolean> filter)
			throws IllegalMusicMediaException {
		boolean validate;

		validate = false;
		try {
			validate = filter.check(data);
		} catch (IllegalMusicLibraryException e) {
			System.out.println(e.getMessage());
		}

		return validate;
	}

	
	
	public static boolean validation(final int data, final int data2,
			final MusicMediaInterfaceDoubleArgument<Integer,Integer, Boolean> filter) throws IllegalMusicMediaException {
		boolean validate;

		validate = false;
		try {
			validate = filter.check(data,data2);
		} catch (IllegalMusicLibraryException e) {
			System.out.println(e.getMessage());
		}

		return validate;
	}

	public String getSKUSubString() {
		String sku;
		String skuSubstring;

		sku          = this.getSku();
		skuSubstring = sku.substring(BEGINNING_INDEX_SKU_ID, ENDING_INDEX_SKU_ID);

		return skuSubstring;
	}

	/**
	 * Sets the song title.
	 *
	 * @param songTitle the title of the song to be set
	 */
	public void setSongTitle(final String songTitle) {
		try {
			validation(songTitle, Validations::validateString);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}
		this.songTitle = songTitle;
	}

	/**
	 * Sets the artist name.
	 *
	 * @param artist the name of the artist to be set
	 */
	public void setArtist(final String artist) {
		try {
			validation(artist, Validations::validateString);

		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}
		this.artist = artist;
	}

	/**
	 * Gets the song title.
	 *
	 * @return the title of the song
	 */
	public String getSongTitle() {
		return songTitle;
	}

	/**
	 * Gets the artist name.
	 *
	 * @return the name of the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Gets the year the record was made.
	 * 
	 * @return the year the record was made
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year the record was made to the year passed to the method.
	 * 
	 * @param year the year the record was made we are passing to the method
	 */
	public void setYear(final int year) {
		try {
			validation(year, Validations::validateYear);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		this.year = year;
	}

	/**
	 * Gets the SKU
	 * 
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * Sets the SKU to the SKU string passed to the function.
	 * 
	 * @param sku the sku code
	 */
	public void setSku(final String sku) {
		try {
			validation(sku, Validations::validateSku);

		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}
		this.sku = sku;
	}

	/**
	 * abstract method for play.
	 */
	abstract void play();

	/**
	 * Displays the object as a string.
	 * 
	 * @return the object as a string
	 */
	@Override
	public String toString() {
		return "MusicMedia [sku=" + sku + ", songTitle=" + songTitle + ", artist=" + artist + ", year=" + year + "]";
	}
}
