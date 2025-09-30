package com.banki.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardDb {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    // CREATE
    public void addCard(int deckId, String question, String answer) {
        String sql = "INSERT INTO cards(deckId, question, answer) VALUES(?, ?, ?)";
        try (Connection conn = Database.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, deckId);
            pstmt.setString(2, question);
            pstmt.setString(3, answer);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed to initialize database", e);
        }
    }

    // READ ALL CARDS FOR A DECK
    public List<String> getCardsForDeck(int deckId) {
        List<String> cards = new ArrayList<>();
        String sql = "SELECT * FROM cards WHERE deckId=?";
        try (Connection conn = Database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, deckId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String card = "Q: " + rs.getString("question") + " | A: " + rs.getString("answer");
                    cards.add(card);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed to initialize database", e);
        }
        return cards;
    }

    // UPDATE
    public void updateCard(int id, String newQuestion, String newAnswer) {
        String sql = "UPDATE cards SET question=?, answer=? WHERE id=?";
        try (Connection conn = Database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newQuestion);
            pstmt.setString(2, newAnswer);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed to initialize database", e);
        }
    }

    // DELETE
    public void deleteCard(int id) {
        String sql = "DELETE FROM cards WHERE id=?";
        try (Connection conn = Database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed to initialize database", e);
        }
    }
}
