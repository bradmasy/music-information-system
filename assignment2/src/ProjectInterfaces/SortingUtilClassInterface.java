package ProjectInterfaces;

import java.util.Scanner;

import ProjectExceptions.IllegalOptionException;
import assignment2.comp2601.bradmasciotra.MusicLibrary;

@FunctionalInterface
/**
 * Represents a Sorting Utility Class Interface.
 * 
 * @author bradley masciotra
 * @version 1.0
 */
public interface SortingUtilClassInterface 
{
	/**
	 * Calls the sorting utlity classes main method.
	 * 
	 * @param library a music media library
	 * @param userInput the users input
	 * @return a boolean value representing to continue the program
	 * @throws IllegalOptionException if the option chosen is out of bound
	 */
	boolean callSort(final MusicLibrary library, final Scanner userInput) throws IllegalOptionException;
}
