package assignment2.comp2601.bradmasciotra;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import ProjectExceptions.IllegalMusicLibraryException;
import ProjectExceptions.IllegalMusicMediaException;
import ProjectInterfaces.MusicLibraryConsumerException;
import UtilityClasses.Validations;

/**
 * Represents a MusicLibrary
 * 
 * @author bradley Masciotra
 * @version 1.0
 */
public final class MusicLibrary {
	final static public String[]      VALID_SKU_REFERENCES;
	final static public int           VR_REFERENCE;
	final static public int           AF_REFERENCE;
	final static public int           CD_REFERENCE;
	final static public int           START_CHARACTER_INDEX;
	final static public int           END_CHARACTER_INDEX;
	final static private MusicLibrary theInstance;

	static {
		VALID_SKU_REFERENCES  = new String[] { "vr", "af", "cd" };
		VR_REFERENCE          = 0;
		AF_REFERENCE          = 1;
		CD_REFERENCE          = 2;
		END_CHARACTER_INDEX   = 2;
		START_CHARACTER_INDEX = 0;
		theInstance           = new MusicLibrary();
	}

	private HashMap<String, MusicMedia> library;

	/**
	 * MusicLibrary Constructor.
	 */
	private MusicLibrary() {
		this.library = new HashMap<String, MusicMedia>();
	}

	/**
	 * Adds the music media selection to the hashmap using the sku code as a
	 * reference
	 * 
	 * @param selection a music media object
	 */
	public void addMusic(final MusicMedia selection) {
		String skuCode;

		skuCode = selection.getSku();
		try {
			MusicMedia.validation(skuCode, Validations::validateSku);
		} catch (IllegalMusicMediaException e) {
			System.out.println(e.getMessage());
		}
		library.put(skuCode, selection);
	}

	/**
	 * Gets the library.
	 * 
	 * @return the library
	 */
	public HashMap<String, MusicMedia> getLibrary() {
		return library;
	}

	/**
	 * Gets the instance of the singleton.
	 * 
	 * @return the music library instance
	 */
	public static MusicLibrary getTheInstance() {
		return theInstance;
	}

	/**
	 * Displays the Music Library.
	 */
	public void displayLibrary() {
		Set<String>      keys;
		Iterator<String> it;
		MusicMedia       selection;

		keys = library.keySet();
		it   = keys.iterator();

		while (it.hasNext()) {
			selection = library.get(it.next());
			System.out.println(selection);
		}
	}

	/**
	 * Gets the SKU code from the music media object.
	 * 
	 * @param selection the music media object we have selected
	 * @return the string from START_CHARACTER_INDEX to END_CHARACTER_INDEX to
	 *         verify which type of music media object the selection is
	 * @throws IllegalMusicLibraryException
	 */
	private String selectionSkuCode(MusicMedia selection) throws IllegalMusicLibraryException {
		String skuCode;

		validations(selection, Validations::validateMusicMediaSelection);
		skuCode = selection.getSku().substring(START_CHARACTER_INDEX, END_CHARACTER_INDEX);
		return skuCode;
	}

	/**
	 * Displays the music media object thats SKU code matches the prefix argument
	 * 
	 * @param prefix a code representing the type music media of music media we are
	 *               searching for
	 */
	public void displayChoice(final String prefix) {
		Set<String>      keys;
		Iterator<String> it;
		MusicMedia       selection;
		String           selectionSKUcode;

		try {
			validations(prefix, Validations::validatePrefix); // throws an exception

			keys = library.keySet();
			it   = keys.iterator();

			while (it.hasNext()) {
				selection = library.get(it.next()); // gets the next selection in the library

				try {
					selectionSKUcode = selectionSkuCode(selection); // throws an exception

					if (selectionSKUcode.equals(prefix)) {
						System.out.println(selection);
					}
				} catch (IllegalMusicLibraryException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (IllegalMusicLibraryException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Applies the given function to the parameter passed.
	 * 
	 * @param <T>      any paramter type (generic)
	 * @param any      the parameter
	 * @param function the function applying the accept method
	 */
	private static <T> void validations(final T any, final MusicLibraryConsumerException function)
			throws IllegalMusicLibraryException {
		try {
			function.accept(any);
		} catch (IllegalMusicLibraryException e) {
			System.out.println(e.getMessage());
		}
	}
}
