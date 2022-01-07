package ProjectExceptions;

/**
 * Represents an Illegal Music Media Exception.
 * This exception is thrown when illegal data is trying to be used for a music media object
 * 
 * @author bradley masciotra
 * @version 1.0
 */
public class IllegalMusicMediaException extends IllegalMusicLibraryException{

	/**
	 * Constructor for IllegalMusicMediaException.
	 * 
	 * @param message the message the exception displays
	 * @param cause the cause of the exception
	 */
	public IllegalMusicMediaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for IllegalMusicMediaException.
	 * 
	 * @param message the message the exception displays
	 */
	public IllegalMusicMediaException(String message) {
		super(message);
	}
}
