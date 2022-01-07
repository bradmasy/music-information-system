package ProjectInterfaces;

import ProjectExceptions.NoMatchException;

@FunctionalInterface
/**
 * Represents a utility consumer interface that accepts two arguments and returns none.
 * 
 * @author bradley masciotra
 * @version 1.0
 *
 * @param <T> any given argument
 * @param <R> any given argument
 */
public interface UtilityBiConsumerInterface<T,R> {

	/**
	 * Accepts the given arguments.
	 * 
	 * @param t the paramter
	 * @param r the paramter
	 * @throws NoMatchException if there are no matches to the parameters
	 */
	 void accept(T t, R r) throws NoMatchException;
}
