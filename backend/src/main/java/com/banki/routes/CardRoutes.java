package com.banki.routes;

import com.banki.models.Card;
import com.banki.services.CardServices;
import com.google.gson.Gson;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

public class CardRoutes {
    public static void registerRoutes() {
        // Create an instance of the service
        CardServices cardServices = new CardServices();
        Gson gson = new Gson();

        // CREATE a card
        post("/card", (req, res) -> {
            cardServices.createCard(req.body());
            res.status(201);
            return "Card created!";
        });

        // READ a single card
        get("/cards/getcard/:id", (req, res) -> {
            int cardId = Integer.parseInt(req.params("id"));
            Card card = cardServices.getCard(cardId);
            res.type("application/json");
            return gson.toJson(card);
        });

        // READ all cards for a deck
        get("/decks/:deckId/cards", (req, res) -> {
            int deckId = Integer.parseInt(req.params("deckId"));
            return cardServices.getCardsForDeck(deckId);
        });

        // UPDATE a card
        put("/cards/:id", (req, res) -> {
            int cardId = Integer.parseInt(req.params("id"));
            cardServices.updateCard(cardId, req.body());
            return "Card updated!";
        });

        // DELETE a card
        delete("/cards/:id", (req, res) -> {
            int cardId = Integer.parseInt(req.params("id"));
            cardServices.deleteCard(cardId);
            return "Card deleted!";
        });
    }
}
