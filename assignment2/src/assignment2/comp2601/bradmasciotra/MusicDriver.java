package assignment2.comp2601.bradmasciotra;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import ProjectExceptions.IllegalMusicLibraryException;
import ProjectExceptions.IllegalOptionException;
import ProjectExceptions.NoMatchException;
import ProjectInterfaces.SearchingUtilityInterface;
import ProjectInterfaces.SortingUtilClassInterface;
import UtilityClasses.SearchingUtilityClass;
import UtilityClasses.SortingUtility;

/**
 * Represents the Driver of the program.
 * 
 * @author Bradley Masciotra
 * @version 1.0
 *
 */
public class MusicDriver {
	final public static int SKU_CODE_INDEX;
	final public static int SONG_TITLE_INDEX;
	final public static int ARTIST_INDEX;
	final static public int START_CHARACTER_INDEX;
	final static public int END_CHARACTER_INDEX;
	final static public int YEAR_INDEX;
	final static public int NUMBER_OF_TRACKS_INDEX;
	final static public int RECORD_WEIGHT_INDEX;
	final static public int RECORD_SIZE_INDEX;
	final static public int FILENAME_INDEX;
	final static public int FILE_RESOLUTION_INDEX;
	final static public int NUMBER_OF_TRACKS;
	final static public int AUDIO_CHOICE;
	final static public int VINYL_CHOICE;
	final static public int CD_CHOICE;
	final static public int EXIT;
	final static public int SKU_INDEX;
	final static public int SEARCH_CHOICE;
	final static public int SORT_CHOICE;
	// sort constants
	final static public int SORT_BY_SKU;
	final static public int SORT_BY_TYPE;
	final static public int SORT_BY_ARTIST;
	final static public int SORT_BY_YEAR;
	final static public int EXIT_SORT;
	// search constants
	final static public int SEARCH_TITLE;
	final static public int SEARCH_ARTIST;
	final static public int SEARCH_YEAR;
	final static public int SEARCH_TYPE;
	final static public int SEARCH_EXIT;
	final static public int NO_MATCHES;
	final static public String AUDIO_FILE;
	final static public String VINYL_FILE;
	final static public String CD_FILE;
	final static public String ERROR_MESSAGE;
	final static public String FILENAME;
	// instance data
	final private MusicLibrary library; 
	
	static {
		SKU_CODE_INDEX         = 0;
		SONG_TITLE_INDEX       = 1;
		ARTIST_INDEX           = 2;
		END_CHARACTER_INDEX    = 2;
		START_CHARACTER_INDEX  = 0;
		YEAR_INDEX             = 3;
		NUMBER_OF_TRACKS_INDEX = 4;
		RECORD_WEIGHT_INDEX    = 5;
		RECORD_SIZE_INDEX      = 6;
		FILENAME_INDEX         = 4;
		FILE_RESOLUTION_INDEX  = 5;
		NUMBER_OF_TRACKS       = 4;
		AUDIO_CHOICE           = 1;
		CD_CHOICE              = 2;
		VINYL_CHOICE           = 3;
		EXIT                   = 6;
		SEARCH_CHOICE          = 5;
		SORT_CHOICE            = 4;
		SORT_BY_SKU            = 1;
		SORT_BY_TYPE           = 2;
		SORT_BY_ARTIST         = 3;
		AUDIO_FILE             = "af";
		VINYL_FILE             = "vr";
		CD_FILE                = "cd";
		SKU_INDEX              = 0;
		SORT_BY_YEAR           = 4;
		EXIT_SORT              = 5;
		SEARCH_TITLE           = 1;
		SEARCH_EXIT            = 5;
		SEARCH_ARTIST          = 2;
		SEARCH_YEAR            = 3;
		SEARCH_TYPE            = 4;
		NO_MATCHES             = 0;
		ERROR_MESSAGE          = "Incorrect Option, Must be an Integer from 1 - 6";
		FILENAME               = "music_data.txt";
		
	}


	/**
	 * Constructor for MusicDriver.
	 */
	public MusicDriver() {
		this.library = MusicLibrary.getTheInstance();
	}

	/*
	 * Creates a Vinyl Record object based on the splitFileLine string array
	 * provided.
	 */
	private void createVinylRecordObject(final String[] splitFileLine) {
		String     skuCode;
		String     title;
		String     artist;
		int        year;
		int        numTracks;
		int        recordWeight;
		int        recordSize;
		MusicMedia vinylRecord;

		skuCode      = null;
		title        = null;
		artist       = null;
		year         = 0;
		numTracks    = 0;
		recordWeight = 0;
		recordSize   = 0;

		for (int i = 0; i < splitFileLine.length; i++) {
			if (i == SKU_CODE_INDEX) {
				skuCode = splitFileLine[i];
			} else if (i == SONG_TITLE_INDEX) {
				title = splitFileLine[i];
			} else if (i == ARTIST_INDEX) {
				artist = splitFileLine[i];
			} else if (i == YEAR_INDEX) {
				year = Integer.parseInt(splitFileLine[i]);
			} else if (i == NUMBER_OF_TRACKS_INDEX) {
				numTracks = Integer.parseInt(splitFileLine[i]);
			} else if (i == RECORD_WEIGHT_INDEX) {
				recordWeight = Integer.parseInt(splitFileLine[i]);
			} else if (i == RECORD_SIZE_INDEX) {
				recordSize = Integer.parseInt(splitFileLine[i]);
			}
		}

		vinylRecord = new VinylRecord(skuCode, title, artist, year, numTracks, recordSize, recordWeight);
		library.addMusic(vinylRecord);
	}

	/*
	 * Creates an Audio File object based on the splitFileLine string array
	 * provided.
	 */
	private void createAudioFile(final String[] splitFileLine) {
		String     skuCode;
		String     title;
		String     artist;
		int        year;
		String     fileName;
		int        fileResolution;
		MusicMedia audioFile;

		skuCode        = null;
		title          = null;
		artist         = null;
		year           = 0;
		fileName       = null;
		fileResolution = 0;

		for (int i = 0; i < splitFileLine.length; i++) {
			if (i == SKU_CODE_INDEX) {
				skuCode = splitFileLine[i];
			} else if (i == SONG_TITLE_INDEX) {
				title = splitFileLine[i];
			} else if (i == ARTIST_INDEX) {
				artist = splitFileLine[i];
			} else if (i == YEAR_INDEX) {
				year = Integer.parseInt(splitFileLine[i]);
			} else if (i == FILENAME_INDEX) {
				fileName = splitFileLine[i];
			} else if (i == FILE_RESOLUTION_INDEX) {
				fileResolution = Integer.parseInt(splitFileLine[i]);
			}
		}

		audioFile = new AudioFile(skuCode, title, artist, year, fileName, fileResolution);
		library.addMusic(audioFile);
	}

	/*
	 * Creates a Compact Disc object based on the splitFileLine string array
	 * provided.
	 */
	private void createCD(final String[] splitFileLine) {
		String     skuCode;
		String     title;
		String     artist;
		int        year;
		int        numberOfTracks;
		MusicMedia compactDisc;

		skuCode        = null;
		title          = null;
		artist         = null;
		year           = 0;
		numberOfTracks = 0;

		for (int i = 0; i < splitFileLine.length; i++) {
			if (i == SKU_CODE_INDEX) {
				skuCode = splitFileLine[i];
			} else if (i == SONG_TITLE_INDEX) {
				title = splitFileLine[i];
			} else if (i == ARTIST_INDEX) {
				artist = splitFileLine[i];
			} else if (i == YEAR_INDEX) {
				year = Integer.parseInt(splitFileLine[i]);
			} else if (i == NUMBER_OF_TRACKS) {
				numberOfTracks = Integer.parseInt(splitFileLine[i]);
			}
		}

		compactDisc = new CompactDisc(skuCode, title, artist, year, numberOfTracks);
		library.addMusic(compactDisc);
	}

	/*
	 * parses each line differently depending on the sku code found.
	 */
	private void sortEachLine(final String fileLine) {
		String[] splitFileLine;
		String   sku;
		String   skuCode;

		splitFileLine = fileLine.split("\\|");
		sku           = splitFileLine[SKU_INDEX];
		skuCode       = sku.substring(START_CHARACTER_INDEX, END_CHARACTER_INDEX);

		if (skuCode.equals("vr")) {
			createVinylRecordObject(splitFileLine);
		} else if (skuCode.equals("af")) {
			createAudioFile(splitFileLine);
		} else if (skuCode.equals("cd")) {
			createCD(splitFileLine);
		}
	}

	/**
	 * Reads the data from the file and parses it into the program depending on the given sku code type.
	 * 
	 * @throws FileNotFoundException if the file is not found
	 */
	public void init() throws FileNotFoundException {

		FileReader musicData;
		Scanner    myReader;
		String     fileLine;

		try {
			musicData = new FileReader(FILENAME);
			myReader  = new Scanner(musicData);

			while (myReader.hasNext()) {
				fileLine = myReader.nextLine();
				sortEachLine(fileLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Displays the files that match the sku code.
	 */
	private boolean displayFiles(final String skuCode) {
		boolean continueProgram;
		continueProgram = true;

		library.displayChoice(skuCode);
		System.out.println();

		return continueProgram;
	}
	/**
	 * Implements the call sort method on the parameters passed.
	 * 
	 * @param library the music library
	 * @param userInput the input recieved from the user
	 * @param function the function we are using to call sort on
	 * @return a boolean value representing to continue the program
	 * @throws IllegalOptionException if the incorrect option is passed
	 */
	public boolean callSortingUtilityClass(final MusicLibrary library, final Scanner userInput, final SortingUtilClassInterface function) 
			throws IllegalOptionException
	{
		boolean b;
		b = function.callSort(library,userInput);
		return b;
	}
	
	/**
	 * Implements the call searching method on the parameters passed.
	 * 
	 * @param library the music library
	 * @param userInput the input recieved from the user
	 * @param function the function we are using to call sort on
	 * @return a boolean value representing to continue the program
	 * @throws IllegalOptionException if the incorrect option is passed
	 * @throws NoMatchException if there are no matches
	 */
	public boolean callSearchingUtilityClass(final MusicLibrary library, final Scanner userInput, final SearchingUtilityInterface<MusicLibrary,Scanner,Boolean> function) 
			throws IllegalOptionException,NoMatchException
	{
		boolean b;
		b = function.sortMethod(library, userInput);
		return b;
	}

//-------------------------------------------------Main-Interface----------------------------------------------------------------------
	/*
	 * Displays the files with the corresponding option chosen.
	 */
	private boolean inputOptions(final int userDecisionInt, final Scanner userInput) throws IllegalMusicLibraryException{
		boolean continueProgram;
		boolean continueOption;

		continueOption  = true;
		continueProgram = false;

		while (continueOption) {
			try {
				if (userDecisionInt == AUDIO_CHOICE) {
					System.out.println();
					continueProgram = displayFiles(AUDIO_FILE);
					continueOption  = false;
				} else if (userDecisionInt == CD_CHOICE) {
					System.out.println();
					continueProgram = displayFiles(CD_FILE);
					continueOption  = false;
				} else if (userDecisionInt == VINYL_CHOICE) {
					System.out.println();
					continueProgram = displayFiles(VINYL_FILE);
					continueOption  = false;
				} else if (userDecisionInt == SORT_CHOICE) {
					System.out.println();
					continueProgram = callSortingUtilityClass(library, userInput, SortingUtility::sortChoices); //sortChoices(userInput);
					continueOption  = false;
				} else if (userDecisionInt == SEARCH_CHOICE) {
					continueProgram = callSearchingUtilityClass(library, userInput, SearchingUtilityClass::searchChoices);
					continueOption  = false;
				} else if (userDecisionInt == EXIT) {
					System.out.println();
					System.out.println("Exiting The Program, Goodbye!");
					userInput.close();
					System.exit(0);
				} else {
					System.out.println();
					throw new IllegalOptionException(ERROR_MESSAGE);
				}
			} catch (IllegalOptionException e) {
				System.out.println(e.getMessage());
				System.out.println();
				
				continueOption  = false;
				continueProgram = true;
			}
		}
		return continueProgram;
	}

	/*
	 * Displays the interface options
	 */
	private void displayOptions() {
		System.out.println("Choose one of the following options:");
		System.out.println("1. Display Audio Files");
		System.out.println("2. Display Compact Discs");
		System.out.println("3. Display Vinyl Records");
		System.out.println("4. Sort Options");
		System.out.println("5. Search Options");
		System.out.println("6. Exit");
		System.out.println();
	}

	/**
	 * Displays the menu interface to the user.
	 * 
	 * @throws IllegalOptionException if an invalid option is chosen
	 */
	public void displayMenu() throws IllegalMusicLibraryException {
		boolean continueProgram;
		Scanner userInput;
		int userDecisionInt;

		userInput       = new Scanner(System.in);
		continueProgram = true;

		while (continueProgram) {
			displayOptions();
			try {
				if (userInput.hasNextInt()) {
					userDecisionInt = userInput.nextInt();
					continueProgram = inputOptions(userDecisionInt, userInput);
				} else {
					throw new IllegalOptionException(ERROR_MESSAGE);
				}
			} catch (IllegalOptionException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
				userInput.next(); // gets the user input once again after the exception has been caught
			}
		}
		System.out.println("Exiting The Program, Goodbye!");
		userInput.close();
	}

	/**
	 * Drives the program.
	 * 
	 * @param args arguments passed to the program.
	 */
	public static void main(final String[] args) {

		MusicDriver driver;
		driver = new MusicDriver();

		try {
			driver.init();
			driver.displayMenu();
		} catch (FileNotFoundException | IllegalMusicLibraryException e) {
			System.out.println(e.getMessage());
		}
	}
}
