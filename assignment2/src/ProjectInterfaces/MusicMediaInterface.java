package ProjectInterfaces;

import ProjectExceptions.IllegalMusicMediaException;

@FunctionalInterface

/**
 * Represents a Music Media Interface.
 * 
 * @author bradley masciotra
 * @version 1.0
 *
 * @param <T> any given parameter
 * @param <R> any given return type
 */
public interface MusicMediaInterface<T,R> {

	/**
	 * Checks the paramater.
	 * 
	 * @param t the function argument
	 * @return the function result
	 * @throws IllegalMusicMediaException if the argument violates the music media validation
	 */
	R check(T t) throws IllegalMusicMediaException;
}
