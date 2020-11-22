package fileexplorer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileExplorerImpl implements FileExplorer {

    @Override
    public String readFileContent(String name) {
        String text = "";

        try {
            System.err.println(name);
            File myObj = new File(name);
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();

                    text = text + data + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("That file doesn't exist.");
            return "That file doesn't exist.";
            //e.printStackTrace();
        }

        return text;
    }

    @Override
    public String listAllFiles() {
        String text = "";

        try (Stream<Path> paths = Files.list(Paths.get(""))) {

            StringBuilder sb = new StringBuilder();

            paths.filter(Files::isRegularFile)
                    .map(x -> x.toString())
                    .forEach(s -> sb.append(s).append('\n'));

            text = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    @Override
    public String deleteFile(String name) {
        String text = "";

        File file = new File(name);

        if (file.delete()) {
            text = "File deleted successfully";
            System.out.println("File deleted successfully");
        } else {
            text = "File doesn't exist. ";
            System.out.println("File doesn't exist. ");
        }

        return text;
    }

    @Override
    public String createFile(String name) {
        String text = "";

        try {
            File myObj = new File(name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                text="File created: " + myObj.getName();
            } else {
                System.out.println("File already exists.");
                text="File already exists.";
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            text="An error occurred.";
            e.printStackTrace();
        }

        return text;
    }

}
