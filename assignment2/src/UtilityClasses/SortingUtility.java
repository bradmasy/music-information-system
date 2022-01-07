package UtilityClasses;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import ProjectExceptions.IllegalOptionException;
import ProjectExceptions.IllegalUtilityClassCreationException;
import assignment2.comp2601.bradmasciotra.MusicLibrary;
import assignment2.comp2601.bradmasciotra.MusicMedia;

/**
 * Represents the utility class for all sorting functions in the program.
 * 
 * @author bradley masciotra
 * @version 1.0
 *
 */
final public class SortingUtility {

	final static public int SORT_BY_SKU;
	final static public int SORT_BY_TYPE;
	final static public int SORT_BY_ARTIST;
	final static public int SORT_BY_YEAR;
	final static public int EXIT_SORT;
	final static public int SORT_CHOICE;
	
	static
	{
		SORT_CHOICE    = 4;
		SORT_BY_SKU    = 1;
		SORT_BY_TYPE   = 2;
		SORT_BY_ARTIST = 3;
		SORT_BY_YEAR   = 4;
		EXIT_SORT      = 5;
	}
	
	/**
	 * Constructor for Sorting Utility Class // ensuring an instance does not get created
	 */
	private SortingUtility()
	{
		try {
			Validations.IllegalClassCreation();
		}
		catch(IllegalUtilityClassCreationException e)
		{
			System.out.println(e.getMessage());
		}
	}
	/**
	 *  Displays the sorting menu options.
	 */
	public static void displaySortingMenu() {
		System.out.println("Choose one of the following options:");
		System.out.println("1. By SKU");
		System.out.println("2. By Type");
		System.out.println("3. By Artist");
		System.out.println("4. By Year");
		System.out.println("5. Main Menu");
	}
	
	/**
	 *  Sorts the music media files but the sku code.
	 *  
	 * @param library a music library
	 * @return a boolean value representing to continue the program
	 */
	public static boolean sortBySku(final MusicLibrary library) {

		boolean          continueOption;
		List<MusicMedia> sortedList;

		continueOption = true;
		
		sortedList = library.getLibrary().values().stream().sorted(Comparator.comparing(eachMusic -> eachMusic.getSku())).collect(Collectors.toList());
		sortedList.forEach(System.out::println);
		System.out.println();

		return continueOption;
	}

	/**
	 * Sorts the contents of library by the type of music file.
	 * 
	 * @param library a music library
	 * @return a boolean value representing to continue the program
	 */
	public static boolean sortByType(final MusicLibrary library) {
		boolean continueOption;
		List<MusicMedia> sortedList;

		continueOption = true;

		sortedList = library.getLibrary().values().stream().sorted(Comparator.comparing(eachMusic -> eachMusic.getSku().substring(0, 2)))
				.collect(Collectors.toList());
		sortedList.forEach(System.out::println);
		System.out.println();
		return continueOption;
	}
	
	/**
	 * Sorts the contents of library by the artist name of the music file.
	 * 
	 * @param library a music library
	 * @return a boolean value representing to continue the program
	 */
	public static boolean sortByArtist(final MusicLibrary library) {
		boolean continueOption;
		continueOption = true;

		List<MusicMedia> sortedList;

		sortedList = library.getLibrary().values().stream()
				.sorted(Comparator.comparing(eachMusic -> eachMusic.getArtist())).collect(Collectors.toList());
		sortedList.forEach(System.out::println);
		System.out.println();

		return continueOption;
	}
	
	/**
	 * Sorts the contents of library by the year of the music file.
	 * 
	 * @param library a music library
	 * @return a boolean value representing to continue the program
	 */
	public static boolean sortByYear(final MusicLibrary library) {
		boolean continueOption;
		continueOption = true;

		List<MusicMedia> sortedList;

		sortedList = library.getLibrary().values().stream()
				.sorted(Comparator.comparing(eachMusic -> eachMusic.getYear())).collect(Collectors.toList());
		sortedList.forEach(System.out::println);
		System.out.println();

		return continueOption;
	}

	/**
	 * Calls the apply method on the parameter library passed.
	 * 
	 * @param library a music library
	 * @param filter the function we are applying to the library
	 * @return a boolean value representing to continue the program
	 */
	public static boolean chooseSortOption(final MusicLibrary library ,final Function<MusicLibrary,Boolean> filter) {
		boolean continueProgram;
		continueProgram = filter.apply(library);

		return continueProgram;
	}
	
	/**
	 * Chooses which sorting option to enact based on the integer passed by the user.
	 * 
	 * @param library the music library
	 * @param userDecisionInt the option choice provided by the user as an integer
	 * @param userInput the input recieved from the user
	 * @return a boolean value representing to continue the program
	 * @throws IllegalOptionException if the incorrect option is passed
	 */
	public static boolean sortingChoiceIntPassed(final MusicLibrary library, final int userDecisionInt, final Scanner userInput)
			throws IllegalOptionException {
		boolean continueOption;
		boolean continueProgram;

		continueOption  = true;
		continueProgram = true;
		while (continueOption) {
			try {
				
				if (userDecisionInt == SORT_BY_SKU) {
					System.out.println();
					continueProgram = chooseSortOption(library,SortingUtility::sortBySku);
					continueOption  = false;

				} else if (userDecisionInt == SORT_BY_TYPE) {
					System.out.println();
					continueProgram = chooseSortOption(library,SortingUtility::sortByType);
					continueOption  = false;

				} else if (userDecisionInt == SORT_BY_ARTIST) {
					System.out.println();
					continueProgram = chooseSortOption(library,SortingUtility::sortByArtist);
					continueOption  = false;

				} else if (userDecisionInt == SORT_BY_YEAR) {
					System.out.println();
					continueProgram = chooseSortOption(library,SortingUtility::sortByYear);
					continueOption  = false;

				} else if (userDecisionInt == EXIT_SORT) {
					System.out.println();
					continueOption  = false;
					continueProgram = false;

				} else {
					throw new IllegalOptionException("Incorrect Option: Must be an Integer From " + SORT_BY_SKU + " - " + EXIT_SORT + ", Try Again.");
				}
			} catch (IllegalOptionException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
				continueOption  = false;
				continueProgram = true;
			}
		}
		return continueProgram;

	}
	
	
	/**
	 * Splits the direction of the program based on the user input passed on which sorting function to apply.
	 * 
	 * @param library the music library
	 * @param userInput the input recieved from the user
	 * @return a boolean value representing to continue the program
	 * @throws IllegalOptionException if the incorrect option is passed
	 */
	public static boolean sortChoices(final MusicLibrary library, final Scanner userInput) throws IllegalOptionException {
		int userDecisionInt;
		boolean continueOption;
		boolean continueProgram;

		continueOption  = true;
		continueProgram = true;

		while (continueOption) {
			try {
				displaySortingMenu();
				System.out.println();

				if (userInput.hasNextInt()) {
					userDecisionInt = userInput.nextInt();
					continueOption  = sortingChoiceIntPassed(library, userDecisionInt, userInput);
				} else {
					throw new IllegalOptionException("Incorrect Option: Must be an Integer From 1 - 5, Try Again.");
				}
			} catch (IllegalOptionException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
				userInput.next();
				continueOption  = true;
				continueProgram = true;
			}
		}
		return continueProgram;
	}
	
	
	
	
	
	
}
