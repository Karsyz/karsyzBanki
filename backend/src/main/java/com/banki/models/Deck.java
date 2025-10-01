package com.banki.models;

public class Deck {
    private int id;
    private String name;

    public Deck(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
}
