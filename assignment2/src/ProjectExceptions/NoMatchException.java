package ProjectExceptions;

/**
 * Represents a No Match Exception.
 * This exception is thrown when a match has not been found in a search query.
 * 
 * @author bradley masciotra
 * @version 1.0
 */
public class NoMatchException extends IllegalMusicLibraryException {

	/**
	 * Constructor for No Match Exception.
	 * 
	 * @param message the message the exception displays
	 */
	public NoMatchException(String message) {
		super(message);
	}

	/**
	 * Constructor for No Match Exception.
	 * 
	 * @param message the message the exception displays
	 * @param cause the cause of the exception
	 */
	public NoMatchException(String message, Throwable cause) {
		super(message, cause);
	}
}
