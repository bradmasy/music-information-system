package ProjectInterfaces;

import ProjectExceptions.IllegalOptionException;

@FunctionalInterface
/**
 * Represents a Utility Consumer Option Interface which accepts an arguments, returns none 
 * and throws an Illegal option exception if the paramter is an incorrect option
 * 
 * @author bradley masciotra
 * @version 1.0
 *
 * @param <T> and type
 */
public interface UtilityConsumerOptionInterface<T> {
	
	/**
	 * 
	 * @param t the given argument
	 * @throws IllegalOptionException if the option is incorrect
	 */
	void accept(T t) throws IllegalOptionException;
}
