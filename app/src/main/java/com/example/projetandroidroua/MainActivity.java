package com.example.projetandroidroua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Créez un Intent pour passer à l'activité de connexion
                Intent intent = new Intent(MainActivity.this, ConnexionActivity.class);
                // Lancez l'activité de connexion
                startActivity(intent);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Créez un Intent pour passer à l'activité de connexion
                Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
                // Lancez l'activité de connexion
                startActivity(intent);
            }
        });
    }   }