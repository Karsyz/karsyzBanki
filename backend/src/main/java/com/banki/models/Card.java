package com.banki.models;

public class Card {
    private int id;
    private Integer deckId;
    private String question;
    private String answer;

    public Card(int id, Integer deckId, String question, String answer) {
        this.id = id;
        this.deckId = deckId;
        this.question = question;
        this.answer = answer;
    }

    // Getters
    public int getId() { return id; }
    public int getDeckId() { return deckId; }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
}

