package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

class AddData {
    private static final Logger logger = Logger.getLogger(AddData .class.getName());

    public static void addWord(Connection connection, String russianWord, String englishWord) throws SQLException {
        // Проверка, существует ли уже русское слово в таблице russian_words
        String russianWordQuery = "SELECT id FROM russian_words WHERE word = ?";
        try (PreparedStatement russianWordStatement = connection.prepareStatement(russianWordQuery)) {
            russianWordStatement.setString(1, russianWord);
            ResultSet russianWordResult = russianWordStatement.executeQuery();

            if (!russianWordResult.next()) {
                // Русское слово не существует, добавляем его в таблицу russian_words
                String insertRussianWordQuery = "INSERT INTO russian_words (word) VALUES (?)";
                try (PreparedStatement insertRussianWordStatement = connection.prepareStatement(insertRussianWordQuery)) {
                    insertRussianWordStatement.setString(1, russianWord);
                    insertRussianWordStatement.executeUpdate();
                }
                logger.info("Добавлено новое русское слово: " + russianWord);
            }
        }

        // Проверка, существует ли уже английское слово в таблице english_words
        String englishWordQuery = "SELECT id FROM english_words WHERE word = ?";
        try (PreparedStatement englishWordStatement = connection.prepareStatement(englishWordQuery)) {
            englishWordStatement.setString(1, englishWord);
            ResultSet englishWordResult = englishWordStatement.executeQuery();

            if (!englishWordResult.next()) {
                // Английское слово не существует, добавляем его в таблицу english_words
                String insertEnglishWordQuery = "INSERT INTO english_words (word) VALUES (?)";
                try (PreparedStatement insertEnglishWordStatement = connection.prepareStatement(insertEnglishWordQuery)) {
                    insertEnglishWordStatement.setString(1, englishWord);
                    insertEnglishWordStatement.executeUpdate();
                }
                logger.info("Добавлено новое английское слово: " + englishWord);
            }
        }

        // Получаем идентификаторы русского и английского слов
        int russianWordId = getWordId(connection, "russian_words", russianWord);
        int englishWordId = getWordId(connection, "english_words", englishWord);

        // Проверяем, существует ли уже связь между словами в таблице translations
        String translationQuery = "SELECT id FROM translations WHERE russian_word_id = ? AND english_word_id = ?";
        try (PreparedStatement translationStatement = connection.prepareStatement(translationQuery)) {
            translationStatement.setInt(1, russianWordId);
            translationStatement.setInt(2, englishWordId);
            ResultSet translationResult = translationStatement.executeQuery();

            if (!translationResult.next()) {
                // Связь не существует, добавляем ее в таблицу translations
                String insertTranslationQuery = "INSERT INTO translations (russian_word_id, english_word_id) VALUES (?, ?)";
                try (PreparedStatement insertTranslationStatement = connection.prepareStatement(insertTranslationQuery)) {
                    insertTranslationStatement.setInt(1, russianWordId);
                    insertTranslationStatement.setInt(2, englishWordId);
                    insertTranslationStatement.executeUpdate();
                }
                logger.info("Создана связь между русским словом '" + russianWord + "' и английским словом '" + englishWord + "'.");
            }
        }
    }

    private static int getWordId(Connection connection, String tableName, String word) throws SQLException {
        String query = "SELECT id FROM " + tableName + " WHERE word = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, word);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        }
        throw new SQLException("Слово '" + word + "' не найдено в таблице " + tableName + ".");
    }
}