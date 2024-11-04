package task_2;

public class Main {
    public static void main(String[] args) {
        // check if file paths are provided as command-line arguments
        if (args.length == 0) {
            System.out.println("Please provide at least one file path as a command-line argument.");
            return;
        }

        // create a FileReader instance
        FileReader fileReader = new FileReader();

        // iterate over each file path provided in args
        for (String filePath : args) {
            System.out.println("\nProcessing file: " + filePath);

            // read the file content
            String text = fileReader.readFileIntoString(filePath);

            if (text.isEmpty()) {
                System.out.println("Failed to read content from " + filePath);
                continue;
            }

            // create and print the TextData analysis for each file
            TextData textData = new TextData(filePath, text);
            System.out.println(textData);
        }
    }
}