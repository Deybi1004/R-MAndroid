package com.example.rickandmorty;

import com.example.rickandmorty.model.Character;

import java.util.List;

public class CharacterResponse {
    private List<Character> result;

    public List<Character> getResult() {
        return result;
    }

    public void setResult(List<Character> result) {
        this.result = result;
    }
}
