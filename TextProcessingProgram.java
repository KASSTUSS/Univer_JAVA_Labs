import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextProcessingProgram {
    private static final String FILE_PATH = "text.txt";

    public static void main(String[] args) {
        String text = readTextFromFile(FILE_PATH);
        text = text.replaceAll("\\s+", " "); // Replace tabs and multiple spaces with a single space

        // Parse the text into paragraphs, sentences, and lexemes
        TextParser parser = new TextParser();
        parser.parse(text);

        // Find the longest palindrome substring
        String longestPalindrome = findLongestPalindromeSubstring(text);
        System.out.println("Longest palindrome substring: " + longestPalindrome);
    }

    private static String readTextFromFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return sb.toString();
    }

    private static String findLongestPalindromeSubstring(String text) {
        text = text.replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters
        String longestPalindrome = "";

        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String substring = text.substring(i, j);
                if (isPalindrome(substring) && substring.length() > longestPalindrome.length()) {
                    longestPalindrome = substring;
                }
            }
        }

        return longestPalindrome;
    }

    private static boolean isPalindrome(String str) {
        StringBuilder reverseStr = new StringBuilder(str).reverse();
        return str.equalsIgnoreCase(reverseStr.toString());
    }
}