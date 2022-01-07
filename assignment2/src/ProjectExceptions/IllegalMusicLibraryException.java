package ProjectExceptions;

/**
 * Represents an Illegal Music Library Exception.
 * This exception is thrown when an illegal operation is done in the MusicLibrary Class.
 * 
 * @author bradley masciotra
 * @version 1.0
 */
public class IllegalMusicLibraryException extends Exception {
	
	/**
	 * Constructor for Illegal Music Library.
	 * 
	 * @param message the message the exception displays
	 * @param cause the cause of the exception
	 */
	public IllegalMusicLibraryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for Illegal Music Library.
	 * 
	 * @param message the message the exception displays
	 */
	public IllegalMusicLibraryException(String message) {
		super(message);
	}

}
