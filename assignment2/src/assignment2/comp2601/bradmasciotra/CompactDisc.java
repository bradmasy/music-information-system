package assignment2.comp2601.bradmasciotra;

import ProjectExceptions.IllegalMusicMediaException;
import UtilityClasses.Validations;

/**
 * Represents a Compact Disc.
 *
 * @author Bradley Masciotra
 * @version 1.0
 */
public class CompactDisc extends MusicMedia {
	// constants
	final static int INVALID_AMOUNT_OF_TRACKS = 0;

	private int numberOfTracks;

	public CompactDisc() {
		super();
	}

	/**
	 * Constructor for CompactDisc.
	 *
	 * @param songTitle      the title of the song
	 * @param artist         the name of the artist
	 * @param numberOfTracks the number of tracks
	 */
	public CompactDisc(final String sku,
                       final String songTitle,
                       final String artist,
                       final int    year,
			           final int    numberOfTracks)
	{
		super(sku, songTitle, artist, year); // all parameters are validated in music media

		try {
			validation(numberOfTracks, Validations::validateInt);

		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}
		this.numberOfTracks = numberOfTracks;
	}

	/**
	 * Gets the number of tracks.
	 * 
	 * @return the number of tracks
	 */
	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	/**
	 * Sets the number of tracks to the amount passed to the method.
	 * 
	 * @param numberOfTracks the number of tracks on the compact disc
	 */
	public void setNumberOfTracks(final int numberOfTracks) {
		try {
			validation(numberOfTracks, Validations::validateInt);

		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		this.numberOfTracks = numberOfTracks;
	}

	/**
	 * Displays the object as a string.
	 * 
	 * @return the object as a string
	 */
	@Override
	public String toString() {
		return "CompactDisc [numberOfTracks=" + numberOfTracks + " , toString()=" + super.toString() + "]";
	}

	/*
	 * displays the disc being played.
	 */
	@Override
	public void play() {
		System.out.println("The Compact Disc is Being Played");
	}

}
