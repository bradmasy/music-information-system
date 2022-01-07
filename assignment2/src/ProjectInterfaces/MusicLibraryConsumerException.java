package ProjectInterfaces;

import ProjectExceptions.IllegalMusicLibraryException;
@FunctionalInterface

/**
 * Represents a Music Library Consumer that throws an Exception.
 * 
 * @author bradley masciotra
 * @version 1.0
 */
public interface MusicLibraryConsumerException {

	/**
	 * Performs this operation on the given argument.
	 * 
	 * @param <T> any type
	 * @param t the given argument
	 * @throws IllegalMusicLibraryException if the argument violates the music library validations
	 */
	<T> void accept(T t) throws IllegalMusicLibraryException;
}
