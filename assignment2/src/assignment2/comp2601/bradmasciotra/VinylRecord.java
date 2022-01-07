package assignment2.comp2601.bradmasciotra;

import ProjectExceptions.IllegalMusicMediaException;
import UtilityClasses.Validations;

/**
 * Represents a Vinyl Record.
 *
 * @author Bradley Masciotra
 * @version 1.0
 */
public class VinylRecord extends MusicMedia
{

	// constants
	final public static int   STANDARD_WEIGHT;
	final public static int   DEFAULT_SIZE;

	static
	{
		STANDARD_WEIGHT = 140;
		DEFAULT_SIZE    = 12;
	}

	// instance data
	private int numberOfTracks;
	private int recordSize;
	private int weightInGrams;

	public VinylRecord() 
	{
		// most basic verion of vinyl record
		super();
	}

	/**
	 * Constructor for Vinyl Record.
	 *
	 * @param songTitle      a title of a song
	 * @param artist         the name of the artist
	 * @param numberOfTracks the number of tracks
	 * @param recordSize     the recordSize of the vinyl record in inches
	 * @param weightInGrams  the weight of the record in grams
	 */
	public VinylRecord(final String sku,
                       final String songTitle,
                       final String artist,
                       final int    year, // validated in Music Media
			           final int    numberOfTracks) 
	{
		super(sku, songTitle, artist, year);
		
		try {
			validation(numberOfTracks, Validations::validateInt);
		}
		catch(IllegalMusicMediaException e)
		{
			System.out.println(e.getMessage());
		}
		
		this.numberOfTracks = numberOfTracks;
		this.recordSize     = DEFAULT_SIZE; // we are setting the values
		this.weightInGrams  = STANDARD_WEIGHT;
	}

	/**
	 * Constructor for Vinyl Record.
	 *
	 * @param songTitle      a title of a song
	 * @param artist         the name of the artist
	 * @param numberOfTracks the number of tracks
	 * @param recordSize     the recordSize of the vinyl record in inches
	 * @param weightInGrams  the weight of the record in grams
	 */
	public VinylRecord(final String sku,
			           final String songTitle,
			           final String artist,
			           final int year,
			           final int numberOfTracks,
			           final int recordSize,
			           final int weightInGrams) 
	{
		this(sku, songTitle, artist, year, numberOfTracks); // chaining the constructors, validations done in prv constructor
	
		try {
			validation(recordSize, Validations::validateRecordSize);
			validation(weightInGrams, recordSize, Validations::validateRecordWeight);
		}
		catch(IllegalMusicMediaException e)
		{
			System.out.println(e.getMessage());
		}
		
		this.numberOfTracks = numberOfTracks;
		this.recordSize     = recordSize;
		this.weightInGrams  = weightInGrams;	
	}
	
	/**
	 * Gets the number of tracks.
	 *
	 * @return the number of tracks
	 */
	public int getNumberOfTracks()
	{
		return numberOfTracks;
	}

	/**
	 * Sets the number of tracks to the numberOfTracks passed.
	 *
	 * @param numberOfTracks the number of tracks
	 */
	public void setNumberOfTracks(final int numberOfTracks) 
	{
		try {
			validation(numberOfTracks, Validations::validateInt);
		}
		catch(IllegalMusicMediaException e)
		{
			System.out.println(e.getMessage());
		}
		this.numberOfTracks = numberOfTracks;
	}

	/**
	 * Gets the size of the record.
	 *
	 * @return the size of the record
	 */
	public int getRecordSize()
	{
		return recordSize;
	}

	/**
	 * Sets the size of the record to recordSize integer passed.
	 *
	 * @param recordSize the size of the record
	 */
	public void setRecordSize(final int recordSize) 
	{
		try
		{
			validation(recordSize, Validations::validateRecordSize);
		}
		catch(IllegalMusicMediaException e)
		{
			System.out.println(e.getMessage());
		}
		this.recordSize = recordSize;
	}

	/**
	 * Gets the weight of the record in grams.
	 *
	 * @return the weight of the record in grams
	 */
	public int getWeightInGrams() 
	{
		return weightInGrams;
	}

	/**
	 * Sets the weight of the record to that of the weightInGrams integer passed.
	 *
	 * @param weightInGrams the weight in grams we wish to set the record weight to
	 */
	public void setWeightInGrams(final int weightInGrams, final int size) 
	{
		try {
			validation(weightInGrams, size, Validations::validateRecordWeight);
		}
		catch(IllegalMusicMediaException e)
		{
			System.out.println(e.getMessage());
		}
		
		this.weightInGrams = weightInGrams;
	}

	/**
	 * Displays the object as a string.		
	 * 
	 * @return the object as a string
	 */
	@Override
	public String toString()
	{
		return "VinylRecord [numberOfTracks=" + 
	            numberOfTracks + ", recordSize=" + 
				recordSize + ", weightInGrams="
				+ weightInGrams + ", toString()=" +
				super.toString() + "]";
	}

	/**
	 * Displays that the vinyl record is being played.
	 */
	@Override
	void play()
	{
		System.out.println("The Vinyl Record is Being Played");
	}
}
