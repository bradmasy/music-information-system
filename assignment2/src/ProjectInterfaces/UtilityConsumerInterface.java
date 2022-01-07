package ProjectInterfaces;

import ProjectExceptions.IllegalMusicLibraryException;

@FunctionalInterface
/**
 * Represents a Utility Consumer Interface that accepts one argument and returns none.
 * 
 * @author bradley masciotra
 * @version 1.0
 * @param <T> any type
 */
public interface UtilityConsumerInterface<T> {

	/**
	 * Performs this operation on the given argument.
	 * 
	 * @param t ther given argument
	 * @throws IllegalMusicLibraryException if the argument violates the music library validations
	 */
	 void accept(T t) throws IllegalMusicLibraryException;
}
