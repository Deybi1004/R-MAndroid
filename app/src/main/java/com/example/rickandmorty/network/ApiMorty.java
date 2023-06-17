package com.example.rickandmorty.network;

import com.example.rickandmorty.Character2;
import com.example.rickandmorty.DtoCharacters;
import com.example.rickandmorty.model.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMorty {
    @GET("character/1,183")
    Call<DtoCharacters> getCharacters();
}
