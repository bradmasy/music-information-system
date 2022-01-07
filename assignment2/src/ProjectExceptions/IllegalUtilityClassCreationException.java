package ProjectExceptions;

/**
 * Represents an IllegalUtilityClassCreationException.
 * This exception is thrown when in an attempt to create an instance of a utility class (search, sort or validations)
 * 
 * @author bradley masciotra
 * @version 1.0
 */
public class IllegalUtilityClassCreationException extends IllegalMusicLibraryException {

	/**
	 * Constructor for IllegalUtilityClassCreationException
	 * 
	 * @param message the message the exception displays
	 * @param cause the cause of the exception
	 */
	public IllegalUtilityClassCreationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for IllegalUtilityClassCreationException
	 * 
	 * @param message the message the exception displays
	 */
	public IllegalUtilityClassCreationException(String message) {
		super(message);
	}

}
