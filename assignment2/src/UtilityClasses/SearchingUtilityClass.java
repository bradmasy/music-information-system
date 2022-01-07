package UtilityClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import ProjectExceptions.IllegalMusicLibraryException;
import ProjectExceptions.IllegalOptionException;
import ProjectExceptions.IllegalUtilityClassCreationException;
import ProjectExceptions.NoMatchException;
import ProjectInterfaces.SearchingUtilityInterface;
import assignment2.comp2601.bradmasciotra.MusicLibrary;
import assignment2.comp2601.bradmasciotra.MusicMedia;

/**
 * Represents the utility class for all searching functions in the program.
 *
 *@author bradley masciotra
 *@version 1.0
 */
final public class SearchingUtilityClass {

	final static public int SEARCH_TITLE;
	final static public int SEARCH_ARTIST;
	final static public int SEARCH_YEAR;
	final static public int SEARCH_TYPE;
	final static public int SEARCH_EXIT;
	final static public int NO_MATCHES;
	final static public int FIRST_SONG_RECORDING;
	final static public int CURRENT_YEAR;

	static {
		SEARCH_TITLE         = 1;
		SEARCH_EXIT          = 5;
		SEARCH_ARTIST        = 2;
		SEARCH_YEAR          = 3;
		SEARCH_TYPE          = 4;
		NO_MATCHES           = 0;
		FIRST_SONG_RECORDING = 1860;
		CURRENT_YEAR         = 2021;
	}
	
	/**
	 * Constructor for Searching Utility Class  // ensuring an instance does not get created
	 */
	private SearchingUtilityClass()
	{
		try {
			Validations.IllegalClassCreation();
		} catch (IllegalUtilityClassCreationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Displays the searches that match the given title provided.
	 * 
	 * @param library a music library
	 * @param userInput the users input
	 * @return a boolean value representing to continue the program
	 * @throws NoMatchException if there are no matches to the given argument
	 */
	public static boolean searchTitle(final MusicLibrary library, final Scanner userInput) throws NoMatchException {
		boolean          continueOption;
		String           searchFor;
		List<MusicMedia> searchList;

		continueOption = true;
		searchList     = new ArrayList<MusicMedia>();

		System.out.println();
		System.out.println("What Title Are You Searching For:");
		System.out.println();

		userInput.nextLine();
		if (userInput.hasNextLine()) {
			System.out.println();
			searchFor  = userInput.nextLine();
			searchList = library.getLibrary().values().stream()
					.filter(eachMusic -> eachMusic.getSongTitle().equalsIgnoreCase(searchFor))
					.collect(Collectors.toList());
			searchList.forEach(System.out::println);

			try {
				Validations.validateSearchClass(searchList,searchFor, Validations::noMatches);
			}
			catch(NoMatchException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return continueOption;
	}

	/**
	 * Displays the searches that match the given artist provided.
	 * 
	 * @param library a music library
	 * @param userInput the users input
	 * @return a boolean value representing to continue the program
	 * @throws NoMatchException if there are no matches to the given argument
	 */
	public static boolean searchArtist(final MusicLibrary library, final Scanner userInput) throws NoMatchException {
		boolean          continueOption;
		String           searchFor;
		List<MusicMedia> searchList;

		continueOption = true;
		searchList     = new ArrayList<MusicMedia>();

		System.out.println();
		System.out.println("What Artist Are You Searching For:");
		System.out.println();

		userInput.nextLine();
		if (userInput.hasNextLine()) {
			System.out.println();
			searchFor  = userInput.nextLine();
			searchList = library.getLibrary().values().stream()
					.filter(eachMusic -> eachMusic.getArtist().equalsIgnoreCase(searchFor)).sorted(Comparator.comparing(eachMusic -> eachMusic.getSku())) // returning the search but also sorting it in order of the sku/type
					.collect(Collectors.toList());
			searchList.forEach(System.out::println);

			try {
				Validations.validateSearchClass(searchList,searchFor, Validations::noMatches);
			}
			catch(NoMatchException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return continueOption;
	}

	/**
	 * Displays the searches that match the given year provided by the user.
	 * 
	 * @param library a music library
	 * @param userInput the users input
	 * @return a boolean value representing to continue the program
	 * @throws IllegalOptionException if the option choice is not an integer 
	 * @throws NoMatchException if there are no matches to the given argument
	 */
	public static boolean searchYear(final MusicLibrary library, final Scanner userInput)
			throws IllegalOptionException, NoMatchException {
		boolean          continueOption;
		int              searchYear;
		List<MusicMedia> searchList;

		continueOption = true;
		searchList     = new ArrayList<MusicMedia>();

		System.out.println();
		System.out.println("What Year Are You Searching For:");
		System.out.println();

		if (userInput.hasNextInt()) 
		{
			searchYear = userInput.nextInt();
			try {
				Validations.validateSearchClassYear(searchYear, Validations::validateYearSize); // validates the search year is a year where recordings exist
				System.out.println();
				searchList = library.getLibrary().values().stream()
						.filter(eachMedia -> eachMedia.getYear() == searchYear).sorted(Comparator.comparing(eachMusic-> eachMusic.getSku())).collect(Collectors.toList()); // returning the search but also sorting it in order of the sku/type
				searchList.forEach(System.out::println);

				try {
					Validations.validateSearchClass(searchList, searchYear, Validations::noMatches); // checks to see if there are no matches to the given search
				} catch (NoMatchException e) {
					System.out.println(e.getMessage());
				}
			} catch (IllegalOptionException e) {
				System.out.println();
				System.out.println(e.getMessage());
			}
		} else {
			try {
				incorrectOption("Year Must Be a Valid Integer Between " + FIRST_SONG_RECORDING + " - " + CURRENT_YEAR + "." ); // thrown if the user input is not an integer
			} catch (IllegalOptionException e) {
				System.out.println();
				System.out.println(e.getMessage());
				userInput.next();
			}
		}
		return continueOption;
	}

	/**
	 * Displays the searches that match the given type provided by the user.
	 * 
	 * @param library   a music library
	 * @param userInput the input from the user
	 * @return a boolean value representing to continue the program or not
	 * @throws IllegalOptionException if the option choice is not one of the types listed 
	 */
	public static boolean searchType(final MusicLibrary library, final Scanner userInput)
			throws IllegalOptionException {
		boolean          continueOption;
		String           searchFor;
		List<MusicMedia> searchList;

		continueOption = true;
		searchList     = new ArrayList<MusicMedia>();

		System.out.println();
		System.out.println("What Type Are You Searching For? (Type Must Be \"CD\" For Compact Disk, \"VR\" For Vinyl Record, or \"AF\" For Audio File):");
		System.out.println();

		if (userInput.hasNext()) {
			searchFor = userInput.next();
			System.out.println();
			try {
				Validations.validateSearchClassType(searchFor, Validations::validateType);
			} catch (IllegalOptionException e) {
				System.out.println(e.getMessage());
			}

			searchList = library.getLibrary().values().stream()
					.filter(eachMusic -> eachMusic.getSKUSubString().equalsIgnoreCase(searchFor))
					.collect(Collectors.toList());
			searchList.forEach(System.out::println);
		}

		return continueOption;
	}

	/**
	 * Applies the sort method to the paramters passed.
	 * 
	 * @param userInput the input from the user
	 * @param library   a music library
	 * @param function  the function applying the sortMethod
	 * @return a boolean value representing to continue the program or not
	 * @throws IllegalOptionException if the incorrect option is passed
	 */
	public static boolean displaySearchOption(final Scanner userInput, final MusicLibrary library,
			final SearchingUtilityInterface<MusicLibrary, Scanner, Boolean> function)
			throws IllegalOptionException, NoMatchException {
		boolean continueProgram;
		continueProgram = function.sortMethod(library, userInput);
		return continueProgram;
	}

	/**
	 * Throws an IllegalOptionException when the incorrect option is passed.
	 * 
	 * @param message the message to extend
	 * @throws IllegalOptionException if the incorrect option is passed
	 */
	public static void incorrectOption(final String message) throws IllegalOptionException {
		throw new IllegalOptionException(message);
	}

	/**
	 * Calls the various search menu options based on the user input provided.
	 * 
	 * @param library a music library
	 * @param userInput the users input
	 * @param userDecisionInt the integer the user has inputted
	 * @return a boolean value representing to continue the program
	 * @throws IllegalOptionException if the option is out of bound or not a valid integer
	 * @throws NoMatchException if there are no matches to the search
	 */
	public static boolean searchChoicesIntPassed(final MusicLibrary library, final Scanner userInput,
			final int userDecisionInt) throws IllegalOptionException, NoMatchException {
		boolean continueProgram;
		boolean continueOption;

		continueProgram = true;
		continueOption  = true;

		try {
			while (continueOption) {
				if (userDecisionInt == SEARCH_TITLE) {
					continueProgram = displaySearchOption(userInput, library, SearchingUtilityClass::searchTitle);
					continueOption  = false;
				} else if (userDecisionInt == SEARCH_ARTIST) {
					continueProgram = displaySearchOption(userInput, library, SearchingUtilityClass::searchArtist);
					continueOption  = false;
				} else if (userDecisionInt == SEARCH_YEAR) {
					continueProgram = displaySearchOption(userInput, library, SearchingUtilityClass::searchYear);
					continueOption  = false;
				} else if (userDecisionInt == SEARCH_TYPE) {
					continueProgram = displaySearchOption(userInput, library, SearchingUtilityClass::searchType);
					continueOption  = false;
				} else if (userDecisionInt == SEARCH_EXIT) {
					System.out.println();
					continueProgram = false;
					continueOption  = false;
				} else {
					throw new IllegalOptionException(
							"Incorrect Option: Option Out of Bound. Option Value Must Be an Integer Between " + SEARCH_TITLE + " - " + SEARCH_EXIT + ".");
				}
			}
		} catch (IllegalOptionException | NoMatchException e) {
			System.out.println();
			System.out.println(e.getMessage());
		}
		return continueProgram;
	}

	/**
	 * The main driver of the search menu.
	 * 
	 * @param library   a music library
	 * @param userInput the input from the user
	 * @return a boolean value representing to continue the program or not
	 * @throws IllegalOptionException if the incorrect option is passed
	 * @throws NoMatchException if there are no matches
	 */
	public static boolean searchChoices(final MusicLibrary library, final Scanner userInput)
			throws IllegalOptionException, NoMatchException {
		boolean continueProgram;
		boolean continueOption;
		int     userDecisionInt;

		continueProgram = true;
		continueOption  = true;

		while (continueOption) {
			displaySearchMenu();
			try {
				if (userInput.hasNextInt()) {
					userDecisionInt = userInput.nextInt();
					continueOption  = searchChoicesIntPassed(library, userInput, userDecisionInt);
				} else {
					throw new IllegalOptionException(
							"Incorrect Option: Option Must Be An Integer Value Between " + SEARCH_TITLE + " - " + SEARCH_EXIT + ".");
				}
			} catch (IllegalMusicLibraryException e) {
				System.out.println();
				System.out.println(e.getMessage());
				userInput.next();
			}
		}
		return continueProgram;
	}

	/**
	 * Displays the search menu.
	 */
	public static void displaySearchMenu() {
		System.out.println();
		System.out.println("Choose a Search Menu Option:");
		System.out.println("1. Search Title");
		System.out.println("2. Search Artist");
		System.out.println("3. Search Year");
		System.out.println("4. Search Type");
		System.out.println("5. Main Menu");
		System.out.println();
	}

}
