package ProjectExceptions;

/**
 * Represents an Illegal Library Exception.
 * This exception is thrown when an Illegal Library is passed as an argument.
 * 
 * @author bradley masciotra
 * @version 1.0
 *
 */
public class IllegalLibraryException extends IllegalMusicLibraryException{

	/**
	 * Constructor for an Illegal Library Exception.
	 * 
	 * @param message the message the exception displays
	 * @param cause the cause of the exception
	 */
	public IllegalLibraryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for an Illegal Library Exception.
	 * 
	 * @param message the message the exception displays
	 */
	public IllegalLibraryException(String message) {
		super(message);
	}

}
