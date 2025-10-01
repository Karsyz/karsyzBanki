package com.banki.services;

import java.util.List;

import com.banki.db.CardDb;
import com.banki.models.Card;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CardServices {
    private static final Gson gson = new Gson();
    private final CardDb cardDb = new CardDb();


    // CREATE
    public void createCard(String requestBody) {
        JsonObject json = gson.fromJson(requestBody, JsonObject.class);
        Integer deckId = null;

        if(json.has("deckId") && !json.get("deckId").isJsonNull()) {
            deckId = json.get("deckId").getAsInt();
        }
        
        String question = json.get("question").getAsString();
        String answer = json.get("answer").getAsString();

        cardDb.addCard(deckId, question, answer);
    }


    // READ SINGLE CARD
    public Card getCard(int cardId) {
        return cardDb.getCard(cardId);
    }

    // READ ALL CARDS IN DECK
    public List<Card> getCardsForDeck(int deckId) {
        return cardDb.getCardsForDeck(deckId);
    }

    // UPDATE
    public void updateCard(int id, String requestBody) {
        JsonObject json = gson.fromJson(requestBody, JsonObject.class);
        String newQuestion = json.get("question").getAsString();
        String newAnswer = json.get("answer").getAsString();

        cardDb.updateCard(id, newQuestion, newAnswer);
    }

    // DELETE
    public void deleteCard(int id) {
        cardDb.deleteCard(id);
    }
}
