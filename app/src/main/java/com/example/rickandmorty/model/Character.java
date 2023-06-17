package com.example.rickandmorty.model;

import com.example.rickandmorty.Character2;

import java.util.List;

public class Character {
    private List<Character2> results;

    public Character(List<Character2> results) {
        this.results = results;
    }

    public List<Character2> getResults() {
        return results;
    }

    public void setResults(List<Character2> results) {
        this.results = results;
    }
}
