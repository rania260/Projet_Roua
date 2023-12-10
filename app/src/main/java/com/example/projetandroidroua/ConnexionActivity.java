package com.example.projetandroidroua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnexionActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        // Initialisation des vues
        editTextUsername = findViewById(R.id.edt_compte);
        editTextPassword = findViewById(R.id.edt_pwd);
        buttonLogin = findViewById(R.id.button5);

        // Configuration du gestionnaire d'événements pour le bouton de connexion
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupérer les valeurs des champs d'entrée
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();


                // Exemple : Afficher une notification toast avec le nom d'utilisateur
                Toast.makeText(ConnexionActivity.this, "Bienvenue, " + username + "!", Toast.LENGTH_SHORT).show();
                // Revenir à l'activité principale (Main Activity)
                Intent intent = new Intent(ConnexionActivity.this, ProfilActivity.class);
                startActivity(intent);
            }
        });
    }
}