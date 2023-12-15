package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseCreator {
    private static final Logger logger = Logger.getLogger(DatabaseCreator.class.getName());

    public static void main(String[] args) {
        try {
            // Установка соединения с базой данных
            Connection connection = DatabaseConnector.getConnection();

            // Создание таблиц, если они не существуют
            createTables(connection);

            // Закрытие соединения с базой данных
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Ошибка при выполнении операции с базой данных", e);
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        // Создание таблицы для английских слов
        String createEnglishTableQuery = "CREATE TABLE IF NOT EXISTS english_words (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "word VARCHAR(255)" +
                ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createEnglishTableQuery);
        }
        logger.info("Таблица 'english_words' создана или уже существует.");

        // Создание таблицы для русских слов
        String createRussianTableQuery = "CREATE TABLE IF NOT EXISTS russian_words (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "word VARCHAR(255)" +
                ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createRussianTableQuery);
        }
        logger.info("Таблица 'russian_words' создана или уже существует.");

        // Создание таблицы для связи английских и русских слов
        String createTranslationTableQuery = "CREATE TABLE IF NOT EXISTS translations (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "english_word_id INT," +
                "russian_word_id INT," +
                "FOREIGN KEY (english_word_id) REFERENCES english_words(id)," +
                "FOREIGN KEY (russian_word_id) REFERENCES russian_words(id)" +
                ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTranslationTableQuery);
        }
        logger.info("Таблица 'translations' создана или уже существует.");
    }
}