package ProjectInterfaces;

import ProjectExceptions.IllegalMusicMediaException;
@FunctionalInterface

/**
 * Represents a Music Media Interface that takes two arguments.
 * 
 * @author bradley masciotra
 * @version 1.0
 *
 * @param <T> a given parameter, any type
 * @param <B> a given parameter, any type
 * @param <R> a given return, any type
 */
public interface MusicMediaInterfaceDoubleArgument<T,B,R>  {
		/**
		 * Checks paramter t and b and returns type r
		 * 
		 * @param t the function argument
		 * @param b the function argument
		 * @return the function result
		 * @throws IllegalMusicMediaException if the paramters violate the music media validations
		 */
		R check(T t, B b) throws IllegalMusicMediaException;
}
