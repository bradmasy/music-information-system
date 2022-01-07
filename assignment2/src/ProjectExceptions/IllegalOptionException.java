package ProjectExceptions;

/**
 * Represents an Illegal Option Exception.
 * This exception is thrown when an illegal option is given by the user.
 * 
 * @author bradley Masciotra
 * @version 1.0
 *
 */
public class IllegalOptionException extends IllegalMusicLibraryException
{
	/**
	 * Constructor for IllegalOptionException.
	 * 
     * @param message the message the exception displays
	 * @param cause the cause of the exception
	 */
	public IllegalOptionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Constructor for IllegalOptionException.
	 * 
	 * @param message the message the exception displays
	 */
	public IllegalOptionException(String message) {
		super(message);
	}
}
