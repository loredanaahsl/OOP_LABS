package task_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// class to represent the text file and calculate its properties
public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    // constructor accepts text and calculates properties
    public TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        this.calculateProperties();
    }

    // method to calculate all properties of the text data
    private void calculateProperties() {
        this.numberOfVowels = countVowels(this.text);
        this.numberOfConsonants = countConsonants(this.text);
        this.numberOfLetters = countLetters(this.text);
        this.numberOfSentences = countSentences(this.text);
        this.longestWord = findLongestWord(this.text);
    }

    // getters
    public String getFilename() { return this.fileName; }
    public String getText() { return this.text; }
    public int getNumberOfVowels() { return this.numberOfVowels; }
    public int getNumberOfConsonants() { return this.numberOfConsonants; }
    public int getNumberOfLetters() { return this.numberOfLetters; }
    public int getNumberOfSentences() { return this.numberOfSentences; }
    public String getLongestWord() { return this.longestWord; }

    // helper methods to calculate individual properties
    private int countVowels(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) count++;
        }
        return count;
    }

    private int countConsonants(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) count++;
        }
        return count;
    }

    private int countLetters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) count++;
        }
        return count;
    }

    private int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    private String findLongestWord(String text) {
        String longest = "";
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = wordPattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() > longest.length()) longest = word;
        }
        return longest;
    }

    // override toString to provide a summary of the text data
    @Override
    public String toString() {
        return "File: " + fileName + "\n" +
                "Text length: " + text.length() + " characters\n" +
                "Vowels: " + numberOfVowels + "\n" +
                "Consonants: " + numberOfConsonants + "\n" +
                "Letters: " + numberOfLetters + "\n" +
                "Sentences: " + numberOfSentences + "\n" +
                "Longest word: " + longestWord;
    }
}