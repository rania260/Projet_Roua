package com.example.projetandroidroua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class InscriptionActivity extends AppCompatActivity {


    private EditText editTextCompte;
    private EditText editTextPassword;
    private EditText editTextDateInscription;
    private RadioButton radioButtonHomme;
    private RadioButton radioButtonFemme;
    private CheckBox checkBoxArabe;
    private CheckBox checkBoxFrancais;
    private Button buttonInscription;
    private RadioGroup radioGroupGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Initialisation des vues
        editTextCompte = findViewById(R.id.compte);
        editTextPassword = findViewById(R.id.pwd);
        editTextDateInscription = findViewById(R.id.dateInscrit);
        radioGroupGenre = findViewById(R.id.radioGroupGenre);
        radioButtonHomme = findViewById(R.id.radioButtonHomme);
        radioButtonFemme = findViewById(R.id.radioButtonFemme);
        checkBoxArabe = findViewById(R.id.checkBox);
        checkBoxFrancais = findViewById(R.id.checkBox2);
        buttonInscription = findViewById(R.id.button6);

        // Configuration du gestionnaire d'événements pour le bouton d'inscription
        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupérer les valeurs des champs d'entrée
                String compte = editTextCompte.getText().toString();
                String password = editTextPassword.getText().toString();
                String dateInscription = editTextDateInscription.getText().toString();

                // Récupérer la sélection du genre
                String genre = "";
                int selectedId = radioGroupGenre.getCheckedRadioButtonId();
                if (selectedId == radioButtonHomme.getId()) {
                    genre = "Homme";
                } else if (selectedId == radioButtonFemme.getId()) {
                    genre = "Femme";
                }

                // Vérifier les cases à cocher
                boolean isArabeSelected = checkBoxArabe.isChecked();
                boolean isFrancaisSelected = checkBoxFrancais.isChecked();

                // Vous pouvez ajouter ici la logique de traitement des données d'inscription

                // Exemple : Afficher une notification toast avec les informations d'inscription
                String inscriptionInfo = "Compte: " + compte +
                        "\nPassword: " + password +
                        "\nDate d'inscription: " + dateInscription +
                        "\nGenre: " + genre +
                        "\nLangues: " + (isArabeSelected ? "Arabe " : "") + (isFrancaisSelected ? "Français" : "");
                Toast.makeText(InscriptionActivity.this, inscriptionInfo, Toast.LENGTH_SHORT).show();

                // Revenir à l'activité principale (Main Activity)
                Intent intent = new Intent(InscriptionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}