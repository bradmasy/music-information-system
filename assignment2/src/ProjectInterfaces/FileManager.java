package ProjectInterfaces;

/**
 * Represents an FileManager.
 *
 * @author Bradley Masciotra
 * @version 1.0
 */
public interface FileManager 
{
    /**
     * Saves the file.
     *
     * @param fileName the name of the file
     * @param path the path/location of the file
     */
    void save(final String path,final String fileName);

    /**
     * Deletes the file.
     *
     * @param fileName the name of the file
     * @param path the path/location of the file
     */
    void delete(final String path, final String fileName);
}
