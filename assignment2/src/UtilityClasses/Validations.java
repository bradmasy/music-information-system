package UtilityClasses;

import java.util.List;
import ProjectExceptions.IllegalMusicLibraryException;
import ProjectExceptions.IllegalMusicMediaException;
import ProjectExceptions.IllegalOptionException;
import ProjectExceptions.IllegalUtilityClassCreationException;
import ProjectExceptions.NoMatchException;
import ProjectInterfaces.UtilityBiConsumerInterface;
import ProjectInterfaces.UtilityConsumerInterface;
import ProjectInterfaces.UtilityConsumerOptionInterface;
import assignment2.comp2601.bradmasciotra.MusicMedia;

final public class Validations {
	public static final int      CURRENT_YEAR;
	public static final int      FIRST_YEAR;
	public static final int      ILLEGAL_INTEGER;
	public static final String[] VALID_SKU_REFERENCES;
	public static final int      BEGINNING_INDEX_SKU_ID;
	public static final int      ENDING_INDEX_SKU_ID;
	final public static int      ILLEGAL_TRACK_AMOUNT;
	final public static int[]    VALID_SIZES;
	final public static int[]    VALID_WEIGHT_TWELVE_INCH;
	final public static int      VALID_WEIGHT_TEN_INCH;
	final public static int      VALID_WEIGHT_SEVEN_INCH;
	final public static int      VALID_SIZE_SMALL_INDEX;
	final public static int      VALID_SIZE_MEDIUM_INDEX;
	final public static int      VALID_SIZE_LARGE_INDEX;
	final public static int      VALIDATED_WEIGHTS_SMALL_INDEX;
	final public static int      VALIDATED_WEIGHTS_MEDIUM_INDEX;
	final public static int      VALIDATED_WEIGHTS_LARGE_INDEX;
	final public static int      STANDARD_WEIGHT;
	final public static int      DEFAULT_SIZE;
	final static public int      FIRST_SONG_RECORDING;
	final static public int      NO_MATCHES;
	static {
		CURRENT_YEAR                   = 2021;
		FIRST_YEAR                     = 1860;
		ILLEGAL_INTEGER                = 0;
		VALID_SKU_REFERENCES           = new String[] { "vr", "af", "cd" };
		BEGINNING_INDEX_SKU_ID         = 0;
		ENDING_INDEX_SKU_ID            = 2;
		ILLEGAL_TRACK_AMOUNT           = 0;
		VALID_SIZES                    = new int[] { 7, 10, 12 };
		VALID_WEIGHT_TWELVE_INCH       = new int[] { 140, 180, 200 };
		VALID_WEIGHT_TEN_INCH          = 100;
		VALID_WEIGHT_SEVEN_INCH        = 40;
		VALID_SIZE_SMALL_INDEX         = 0;
		VALID_SIZE_MEDIUM_INDEX        = 1;
		VALID_SIZE_LARGE_INDEX         = 2;
		VALIDATED_WEIGHTS_SMALL_INDEX  = 0;
		VALIDATED_WEIGHTS_MEDIUM_INDEX = 1;
		VALIDATED_WEIGHTS_LARGE_INDEX  = 2;
		STANDARD_WEIGHT                = 140;
		DEFAULT_SIZE                   = 12;
		NO_MATCHES                     = 0;
		FIRST_SONG_RECORDING           = 1860;
	}

	/*
	 * Constructor for validations class
	 */
	private Validations() {
		try {
			IllegalClassCreation(); // if someone tries to create an instance throw an exception, the exception will
									// always be thrown when the constructor is called.
		} catch (IllegalUtilityClassCreationException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validates a string to ensure it is not created from improper data.
	 * 
	 * @param value the string we are evaluating
	 * @throws IllegalArgumentException if the boolean is false
	 * @return a boolean representing if the string passes validation or not, true
	 *         if yes and false if no
	 */
	public static boolean validateString(final String value) throws IllegalMusicMediaException {
		boolean validate;
		validate = false;

		if (value != null && (!value.isBlank() || !value.isEmpty())) {
			validate = true;
		} else {
			throw new IllegalMusicMediaException("Improper String: " + value);
		}

		return validate;
	}

	/**F
	 * Validates if the string is of String data type.
	 * 
	 * @param <T> represents any parameter type
	 * @param s   the string we are validating
	 * @return boolean value representing whether the string was validated or not.
	 */
	public static <T> boolean validateStringType(final T s) {
		boolean validated;
		validated = false;

		if (s instanceof String) {
			validated = true;
		}

		return validated;
	}

	/**
	 * Validates the prefix of the SKU code.
	 * 
	 * @param <T> any paramter type (generic)
	 * @param pre the prefix string
	 * @throws IllegalMusicLibraryException if the prefix is not a string or is
	 *                                      invalid
	 */
	public static <T> void validatePrefix(final T pre) throws IllegalMusicLibraryException {
		String preString;
		preString = null;

		if (validateStringType(pre)) {
			preString = (String) pre;
			if (!preString.equalsIgnoreCase("af") && !preString.equalsIgnoreCase("vr")
					&& !preString.equalsIgnoreCase("cd")) {
				throw new IllegalMusicLibraryException("Incorrect SKU Provided.");
			}
		} else {
			throw new IllegalMusicLibraryException("Data Type is Not a String.");
		}
	}

	/**
	 * Validates the year.
	 * 
	 * @param year a given year value
	 * @return a boolean representing if the year was validated
	 * @throws IllegalMusicMediaException if the year is out of bound of FIRST_YEAR
	 *                                    and CURRENT_YEAR
	 */
	public static boolean validateYear(final int year) throws IllegalMusicMediaException {
		boolean validate;
		validate = true;

		if (year < FIRST_YEAR || year > CURRENT_YEAR) {
			throw new IllegalMusicMediaException("Invalid year: " + year);
		}

		return validate;
	}

	/**
	 * Gets the SKU code from index of FIRST_INDEX_SKU_ID and SECOND_INDEX_SKU_ID.
	 */
	private static String getSKUCode(final String sku) {
		String skuCode;

		try {
			MusicMedia.validation(sku, Validations::validateString);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}
		skuCode = sku.substring(BEGINNING_INDEX_SKU_ID, ENDING_INDEX_SKU_ID);

		return skuCode;
	}

	/**
	 * Validates the integer to ensure that it is created from proper data.
	 * 
	 * @param value the integer we are evaluating
	 * @throws IllegalArgumentException if the boolean is false
	 * @return a boolean representing if the string passes validation or not, true
	 *         if yes and false if no
	 */
	public static boolean validateInt(final int value) throws IllegalMusicMediaException {
		boolean validate;
		validate = false;

		if (value > ILLEGAL_INTEGER) {
			validate = true;
		} else {
			throw new IllegalMusicMediaException("Improper Integer: " + value);
		}

		return validate;
	}

	/**
	 * Checks the given SKU code against the acceptable codes.
	 */
	private static boolean getSKUBoolean(final String sku) {

		String stringCode;
		boolean properCode;

		properCode = false;
		stringCode = getSKUCode(sku);

		for (String acceptableCode : VALID_SKU_REFERENCES) {
			if (stringCode.equals(acceptableCode)) {
				properCode = true;
			}
		}

		return properCode;
	}

	/**
	 * Throws an illegal argument exception if there is an improper SKU code.
	 * 
	 * @param sku the given sku code
	 * @return boolean representing if the code is proper or not
	 * @throws IllegalMusicMediaException if the code is improper
	 */
	public static boolean validateSku(final String sku) throws IllegalMusicMediaException {
		boolean properCode;
		properCode = getSKUBoolean(sku);

		if (!properCode) {
			throw new IllegalMusicMediaException("Improper SKU code: " + sku);
		}

		return properCode;
	}

	/**
	 * Validates the given music media selection.
	 * 
	 * @param <T>       any type of parameter (generic type)
	 * @param selection the music media selection
	 * @throws IllegalMusicLibraryException if the selection is null or not of music
	 *                                      media type
	 */
	public static <T> void validateMusicMediaSelection(final T selection) throws IllegalMusicLibraryException {
		boolean valid;

		valid = false;

		if (selection != null) {
			if (selection instanceof MusicMedia) {
				valid = true;
			} else {
				throw new IllegalMusicLibraryException(
						"Improper Selection: Selection \"" + selection + "\" Is Not of MusicMedia Class.");
			}
		} else {
			throw new IllegalMusicLibraryException(
					"Improper Selection: Selection \"" + selection + "\" Can Not Be Null");
		}
	}

	// --------------------------------------------validatations-vinyl-record------------------------------------------------------------------

	/*
	 * Throws an exception if boolean value passed is false.
	 */
	private static void validateRecordBoolean(final boolean correctSize) throws IllegalMusicMediaException {
		if (!correctSize) {
			throw new IllegalMusicMediaException("Incorrect Vinyl Record Size");
		}
	}

	/**
	 * Validates the size of the record to ensure it meets the parameters specified.
	 * 
	 * @param size the size of the record
	 * @return boolean representing the validation of the size
	 */
	public static boolean validateRecordSize(final int size) {
		boolean correctSize;

		correctSize = false;

		for (int i : VALID_SIZES) {
			if (size == i) {
				correctSize = true; // if one of the sizes matches we break the loop as it is correct
				break;
			}
		}

		try {
			validateRecordBoolean(correctSize); // throws the exception if false
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}

		return correctSize;
	}

	/*
	 * Throws an exception if boolean value passed is false.
	 */
	private static void validateRecordWeightBoolean(final boolean correctWeight, final int weight, final int size)
			throws IllegalMusicMediaException {
		if (!correctWeight) {
			throw new IllegalMusicMediaException("Incorrect Weight for \"" + size + "\" Inch Record: " + weight);
		}
	}

	/**
	 * Validates the weight of the record to ensure it meets the parameters
	 * specified.
	 * 
	 * @param weight the weight of the record
	 * @param size   the size of the record
	 * @return boolean representing the validation of the size
	 * @throws IllegalMusicMediaException if the size and weight are incorrect in
	 *                                    reference to eachother
	 */
	public static boolean validateRecordWeight(final int weight, final int size) throws IllegalMusicMediaException {
		boolean validated;

		validated = false;

		if (size == VALID_SIZES[VALID_SIZE_SMALL_INDEX] && weight == VALID_WEIGHT_SEVEN_INCH) {
			validated = true;
		} else if (size == VALID_SIZES[VALID_SIZE_MEDIUM_INDEX] && weight == VALID_WEIGHT_TEN_INCH) {
			validated = true;
		} else if (size == VALID_SIZES[VALID_SIZE_LARGE_INDEX]) {
			for (int eachWeight : VALID_WEIGHT_TWELVE_INCH) {
				if (weight == eachWeight) {
					validated = true;
					break;
				}
			}
		}
		validateRecordWeightBoolean(validated, weight, size);

		return validated;
	}

	/**
	 * Validates the given year passed.
	 * 
	 * @param year a year value
	 * @throws IllegalOptionException if the year is out of bound FIRST_SONG_RECORDING or greater than CURRENT_YEAR
	 */
	public static void validateYearSize(final int year) throws IllegalOptionException {
		if (year > CURRENT_YEAR) {
			throw new IllegalOptionException("Year Out of Bound: \"" + year + "\" is To Large.");
		} else if (year < FIRST_SONG_RECORDING) {
			throw new IllegalOptionException("Year Out of Bound: \"" + year + "\" is To Small.");
		}
	}

	/**
	 * Validates the given string with the function passed.
	 * 
	 * @param s the string to validate
	 * @param function the function doing the validation
	 * @throws IllegalMusicLibraryException if the string is invalid
	 */
	public static void validateSearchClass(final String s, final UtilityConsumerInterface<String> function)
			throws IllegalMusicLibraryException {
		function.accept(s);
	}

	/**
	 * Validates the given integer with the function passed.
	 * 
	 * @param i the integer to validate
	 * @param function the function doing the validation
	 * @throws IllegalMusicLibraryException if the integer is invalid
	 */
	public static void validateSearchClass(final int i, final UtilityConsumerInterface<Integer> function)
			throws IllegalMusicLibraryException {
		function.accept(i);
	}

	/**
	 * Validates the given music media and string against the function passed.
	 * 
	 * @param l a list of music media objects we are searching
	 * @param s the string to validate
	 * @param function the function doing the validation
	 * @throws NoMatchException if there are no matches
	 */
	public static void validateSearchClass(final List<MusicMedia> l, final String s,  final UtilityBiConsumerInterface<List<MusicMedia>,String> function)
			throws NoMatchException {
		function.accept(l,s);
	}
	
	/**
	 * Validates the given music media and integer against the function passed.
	 * 
	 * @param l a list of music media objects we are searching
	 * @param i an integer to validate
	 * @param function the function doing the validation
	 * @throws NoMatchException if there are no matches
	 */
	public static void validateSearchClass(final List<MusicMedia> l, final int i,  final UtilityBiConsumerInterface<List<MusicMedia>,Integer> function)
			throws NoMatchException {
		function.accept(l,i);
	}
	
	/**
	 * Validates the given music media and integer against the function passed.
	 * 
	 * @param i an integer to validate
	 * @param function he function doing the validation
	 * @throws IllegalOptionException if the incorrect option is passed
	 */
	public static void validateSearchClassYear(final int i, final UtilityConsumerOptionInterface<Integer> function)
			throws IllegalOptionException{
		function.accept(i);
	}
	
	/**
	 * Validates the given music media and string against the function passed.
	 * 
	 * @param s the string to validate
	 * @param function the function doing the validation
	 * @throws IllegalOptionException if the incorrect option is passed
	 */
	public static void validateSearchClassType(final String s, final UtilityConsumerOptionInterface<String> function)
			throws IllegalOptionException{
			function.accept(s);
	}
	

	/**
	 * Throws a No Match Exception if the size of the list is equal to NO_MATCHES.
	 * 
	 * @param searchList the list we are checking
	 * @param searchFor  the given string the user had inputed in the original
	 *                   search
	 * @throws NoMatchException if the size of the list is equal to NO_MATCHES
	 */
	public static void noMatches(final List<MusicMedia> searchList, final String searchFor) throws NoMatchException {
		if (searchList.size() == NO_MATCHES) {
			throw new NoMatchException("No Matches For: " + searchFor);
		}
	}

	/**
	 * Throws a No Match Exception if the size of the list is equal to NO_MATCHES.
	 * 
	 * @param searchList the list we are checking
	 * @param year       the given year value the user inputed in the original
	 *                   search
	 * @throws NoMatchException if the size of the list is equal to NO_MATCHES
	 */
	public static void noMatches(final List<MusicMedia> searchList, final int year) throws NoMatchException {
		if (searchList.size() == NO_MATCHES) {
			throw new NoMatchException("No Matches For: " + year);
		}
	}

	/**
	 * Throws an exception if the constructor is called.
	 * 
	 * @throws IllegalUtilityClassCreationException if the constructor is called
	 */
	public static void IllegalClassCreation() throws IllegalUtilityClassCreationException {
		throw new IllegalUtilityClassCreationException("You Can Not Create an Instance of This Class.");
	}
	
	/**
	 * Validates the type searched for.
	 * 
	 * @param searchFor the string being searched
	 * @throws IllegalOptionException if the incorrect option is given
	 */
	public static void validateType(final String searchFor) throws IllegalOptionException {
		if (searchFor.equalsIgnoreCase("af") || searchFor.equalsIgnoreCase("cd") || searchFor.equalsIgnoreCase("vr")) {
		} else {
			throw new IllegalOptionException("Incorrect Choice, Must be af, cd, or vr");
		}
	}
}
