package com.example.starwarsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    androidx.cardview.widget.CardView cardPersonagens;
    androidx.cardview.widget.CardView cardFilmes;
    androidx.cardview.widget.CardView cardNaves;
    androidx.cardview.widget.CardView cardVeiculos;
    androidx.cardview.widget.CardView cardEspecies;
    androidx.cardview.widget.CardView cardPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardPersonagens = (CardView)findViewById(R.id.cardPersonagens);
        cardPersonagens.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListAllResultsSearch.class);
                intent.putExtra("queryString", "people/");

                startActivity(intent);
            }
        });

        cardFilmes = (CardView)findViewById(R.id.cardFilmes);
        cardFilmes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListAllResultsSearch.class);
                intent.putExtra("queryString", "films/");

                startActivity(intent);
            }
        });

        cardNaves = (CardView)findViewById(R.id.cardNaves);
        cardNaves.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListAllResultsSearch.class);
                intent.putExtra("queryString", "starships/");

                startActivity(intent);
            }
        });

        cardVeiculos = (CardView)findViewById(R.id.cardVeiculos);
        cardVeiculos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListAllResultsSearch.class);
                intent.putExtra("queryString", "vehicles/");

                startActivity(intent);
            }
        });

        cardEspecies = (CardView)findViewById(R.id.cardEspecies);
        cardEspecies.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListAllResultsSearch.class);
                intent.putExtra("queryString", "species/");

                startActivity(intent);
            }
        });

        cardPlanetas = (CardView)findViewById(R.id.cardPlanetas);
        cardPlanetas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListAllResultsSearch.class);
                intent.putExtra("queryString", "planets/");

                startActivity(intent);
            }
        });
    }
}