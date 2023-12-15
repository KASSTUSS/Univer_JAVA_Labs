package org.example;

import java.sql.*;
import java.util.Scanner;

import static org.example.DatabaseConnector.getConnection;

public class TranslationSearcher {

    public static void main(String[] args) {
        try {
            // Establishing a database connection
            Connection connection = getConnection();
            System.out.println("Database connection established.");

            // Creating a scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Prompting the user for input
            System.out.print("Enter a word to translate (or 'exit' to quit): ");
            String input = scanner.nextLine();

            while (!input.equalsIgnoreCase("exit")) {
                // Determining the language of the input word
                boolean isEnglish = isEnglishWord(input);

                if (isEnglish) {
                    // Searching for translations from English to Russian
                    searchTranslations(connection, input);
                } else {
                    // Searching for translations from Russian to English
                    searchTranslationsFromRussian(connection, input);
                }

                // Prompting the user for the next word
                System.out.print("Enter a word to translate (or 'exit' to quit): ");
                input = scanner.nextLine();
            }

            // Closing the scanner and the connection
            scanner.close();
            connection.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isEnglishWord(String word) {
        // Checking if the word contains only English alphabets
        return word.matches("[a-zA-Z]+");
    }

    private static void searchTranslations(Connection connection, String word) throws SQLException {
        // Preparing the SQL statement to search for translations from English to Russian
        String sql = "SELECT russian_words.word AS russian_word " +
                "FROM english_words " +
                "JOIN translations ON english_words.id = translations.english_word_id " +
                "JOIN russian_words ON translations.russian_word_id = russian_words.id " +
                "WHERE english_words.word = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Setting the word parameter in the SQL statement
            statement.setString(1, word);

            // Executing the SQL query
            ResultSet resultSet = statement.executeQuery();

            // Checking if any translations were found
            if (resultSet.next()) {
                System.out.println("Translations of '" + word + "':");

                // Printing all the translations
                do {
                    String translation = resultSet.getString("russian_word");
                    System.out.println("- " + translation);
                } while (resultSet.next());
            } else {
                System.out.println("No translations found for '" + word + "'.");
            }

            resultSet.close();
        }
    }

    private static void searchTranslationsFromRussian(Connection connection, String word) throws SQLException {
        // Preparing the SQL statement to search for translations from Russian to English
        String sql = "SELECT english_words.word AS english_word " +
                "FROM russian_words " +
                "JOIN translations ON russian_words.id = translations.russian_word_id " +
                "JOIN english_words ON translations.english_word_id = english_words.id " +
                "WHERE russian_words.word = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Setting the word parameter in the SQL statement
            statement.setString(1, word);

            // Executing the SQL query
            ResultSet resultSet = statement.executeQuery();

            // Checking if any translations were found
            if (resultSet.next()) {
                System.out.println("Translations of '" + word + "':");

                // Printing all the translations
                do {
                    String translation = resultSet.getString("english_word");
                    System.out.println("- " + translation);
                } while (resultSet.next());
            } else {
                System.out.println("No translations found for '" + word + "'.");
            }

            resultSet.close();
        }
    }
}