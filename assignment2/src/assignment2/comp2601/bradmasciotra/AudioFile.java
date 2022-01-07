package assignment2.comp2601.bradmasciotra;

import ProjectExceptions.IllegalMusicMediaException;
import ProjectInterfaces.FileManager;
import UtilityClasses.Validations;

/**
 * Represents an Audio File.
 *
 * @author Bradley Masciotra
 * @version 1.0
 */
public class AudioFile extends MusicMedia implements FileManager {
	// constants
	final static int MINIMUM_SIZE;

	// instance data
	private String fileName;
	private int    fileResolution;

	static {
		MINIMUM_SIZE = 0;
	}

	/**
	 * Constructor for AudioFile.
	 */
	public AudioFile() {
		super();
	}

	/**
	 * Constructor for AudioFile.
	 *
	 * @param sku       the SKU code for the audio file.
	 * @param songTitle the title of the song
	 * @param artist    the artist name
	 * @param year      the year the file was recorded
	 * @param fileName  the name of the file
	 */
	public AudioFile(final String sku, 
			         final String songTitle,
			         final String artist,
			         final int    year,
			         final String fileName) 
	{
		super(sku, songTitle, artist, year); // validations done in music media class

		try {
			validation(fileName, Validations::validateString);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		this.fileName = fileName;
	}

	/**
	 * Constructor for AudioFile.
	 * 
	 * @param sku            the SKU code for the audio file.
	 * @param songTitle      the title of the song
	 * @param artist         the artist name
	 * @param year           the year the file was recorded
	 * @param fileName       the name of the file
	 * @param fileResolution the resolution size of the file
	 */
	public AudioFile(final String sku,
			         final String songTitle, 
			         final String artist, 
			         final int    year,
			         final String fileName, 
			         final int    fileResolution) 
	{
		this(sku, songTitle, artist, year, fileName); // all are validated in previous constructor

		try {
			validation(fileResolution, Validations::validateInt);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		this.fileResolution = fileResolution;
	}

	/**
	 * Gets the name of the file.
	 * 
	 * @return the name of the file
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * sets the name of the file to the string passed.
	 * 
	 * @param fileName the name of the file
	 */
	public void setFileName(final String fileName) {
		try {
			validation(fileName, Validations::validateString);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		this.fileName = fileName;
	}

	/**
	 * Gets the file resolution.
	 * 
	 * @return the file resolution
	 */
	public int getFileResolution() {
		return fileResolution;
	}

	/**
	 * Sets the file resolution to that of the paramter passed.
	 * 
	 * @param fileResolution the file resolution
	 */
	public void setFileResolution(final int fileResolution) {
		try {
			validation(fileResolution, Validations::validateInt);

		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}
		this.fileResolution = fileResolution;
	}

	/**
	 * Saves the file.
	 *
	 * @param fileName the name of the file
	 */
	@Override
	public void save(final String path, final String fileName) {
		try {
			validation(path, Validations::validateString);
			validation(fileName, Validations::validateString);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("saving the audio file: " + fileName);
	}

	/**
	 * Deletes the file.
	 *
	 * @param fileName the name of the file
	 */

	public void delete(final String path, final String fileName) {

		try {
			validation(path, Validations::validateString);
			validation(fileName, Validations::validateString);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("deleting the audio file: " + fileName);
	}

	/**
	 * Displays that an audio file is being played.
	 */
	@Override
	void play() {
		System.out.println("The Audio File is Being Played");
	}

	/**
	 * Displays the object as a string.
	 * 
	 * @return the object as a string
	 */
	@Override
	public String toString() {
		return "AudioFile [fileName=" + fileName + ", fileResolution=" + fileResolution + ", toString()="
				+ super.toString() + "]";
	}

}
