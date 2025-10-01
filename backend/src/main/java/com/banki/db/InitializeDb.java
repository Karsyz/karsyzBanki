package com.banki.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitializeDb {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    public static void initialize() {
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {

            // Example: create users table
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "name TEXT NOT NULL, " +
                         "email TEXT UNIQUE)");

            // Example: create cards table
           stmt.execute("CREATE TABLE IF NOT EXISTS cards (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "deckId INTEGER, " +
                         "question TEXT NOT NULL, " +
                         "answer TEXT NOT NULL, " +
                         "FOREIGN KEY(deckId) REFERENCES decks(id))"                        
                         );

            // Example: create decks table
            stmt.execute("CREATE TABLE IF NOT EXISTS decks (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "name TEXT NOT NULL)");

            System.out.println("Database initialized successfully.");

        } catch (SQLException e) {
            logger.error("Failed to initialize database", e);
        }
    }
}
