package com.example.rickandmorty.network;

import com.example.rickandmorty.model.DtoCharacters;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMorty {
    @GET("character/1,183")
    Call<DtoCharacters> getCharacters();
}
