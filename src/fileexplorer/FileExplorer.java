package fileexplorer;


/**
 * Has the role of exploring the contents of a predefined directory and managing the files stored within.
 *
 * @author Leni
 */
public interface FileExplorer {

    /**
     * 
     * @return 
     */ 
    String readFileContent(String name);
    
    String listAllFiles();
    
    String deleteFile(String name);
    
    String createFile(String name);
    
    String fileWrite(String name,String message);
    
    String fileCreateWrite(String name,String message);
}
