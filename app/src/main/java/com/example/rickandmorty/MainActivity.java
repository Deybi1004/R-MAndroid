package com.example.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.rickandmorty.adapter.CharacterAdapter;
import com.example.rickandmorty.model.Character;
import com.example.rickandmorty.network.ApiClient;
import com.example.rickandmorty.network.ApiMorty;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Character2> characters;
    private RecyclerView recyclerView;
    private CharacterAdapter characterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_characters);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        showCharacters();
    }

    public void showCharacters() {
        Call<List<Character2>> call = ApiClient.getClient().create(ApiMorty.class).getCharacters();
        call.enqueue(new Callback<List<Character2>>() {
            @Override
            public void onResponse(Call<List<Character2>> call, Response<List<Character2>> response) {
                if (response.isSuccessful()) {
                    characters = response.body();

                    characterAdapter = new CharacterAdapter(characters, getApplicationContext());
                    recyclerView.setAdapter(characterAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Character2>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR DE CONEXIÓN ONFAILURE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}