package task_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// class to read file contents into a string
public class FileReader {

    // method to read file contents and return as a single string
    public String readFileIntoString(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println("Error reading file at path: " + path);
            return "";
        }
    }
}