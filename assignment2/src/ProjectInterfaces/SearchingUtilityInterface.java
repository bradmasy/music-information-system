package ProjectInterfaces;

import java.util.Scanner;

import ProjectExceptions.IllegalOptionException;
import ProjectExceptions.NoMatchException;
import assignment2.comp2601.bradmasciotra.MusicLibrary;

@FunctionalInterface

/**
 * Represents a Searching Utility Interface.
 * 
 * @author bradley masciotra
 * @version 1.0
 *
 * @param <L> a music library
 * @param <S> a scanner object
 * @param <B> the returnng boolean
 */
public interface SearchingUtilityInterface<L, S, B> {
	/**
	 * 
	 * @param L a music library
	 * @param S a scanner
	 * @return the function result
	 * @throws IllegalOptionException if the incorrect option is passed
	 * @throws NoMatchException if there are no mathches to the given arguments
	 */
	B sortMethod(final MusicLibrary L, final Scanner S) throws IllegalOptionException, NoMatchException;
}
