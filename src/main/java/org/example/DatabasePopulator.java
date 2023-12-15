package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.DatabaseConnector.getConnection;

public class DatabasePopulator {

    private static final Logger logger = Logger.getLogger(DatabasePopulator.class.getName());

    public static void main(String[] args) {
        try {
            // Establishing a database connection
            Connection connection = getConnection();
            logger.info("Database connection established.");

            // Adding test data
            addTestData(connection);

            // Closing the connection
            connection.close();
            logger.info("Database connection closed.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An error occurred while populating the database.", e);
        }
    }

    private static void addTestData(Connection connection) throws SQLException {
        // Adding test data using the DataPopulator class
        AddData.addWord(connection, "Привет", "Hello");
        AddData.addWord(connection, "Мир", "World");
        AddData.addWord(connection, "Кошка", "Cat");
        AddData.addWord(connection, "Собака", "Dog");
        AddData.addWord(connection, "Яблоко", "Apple");
        AddData.addWord(connection, "Стул", "Chair");
        AddData.addWord(connection, "Дом", "House");
        AddData.addWord(connection, "Книга", "Book");
        AddData.addWord(connection, "Машина", "Car");
        AddData.addWord(connection, "Огонь", "Fire");
        AddData.addWord(connection, "Вода", "Water");
        AddData.addWord(connection, "Солнце", "Sun");
        AddData.addWord(connection, "Низкий", "Low");
        AddData.addWord(connection, "Низкий", "Poor");
        AddData.addWord(connection, "Низкий", "Short");
        // Add more test data as needed
    }
}