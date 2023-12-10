package com.example.projetandroidroua;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ModifActivity extends AppCompatActivity {


    private EditText editTextCompte;
    private EditText editTextPassword;
    private RadioGroup radioGroup;
    private RadioButton radioButtonHomme;
    private RadioButton radioButtonFemme;
    private CheckBox checkBoxArabe;
    private CheckBox checkBoxFrancais;
    private Button buttonEnregistrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif);

        // Initialisation des vues
        editTextCompte = findViewById(R.id.textInputEditText);
        editTextPassword = findViewById(R.id.textInputEditText2);
        radioGroup = findViewById(R.id.radioGroupGenre1);
        radioButtonHomme = findViewById(R.id.radioButton2);
        radioButtonFemme = findViewById(R.id.radioButton);
        checkBoxArabe = findViewById(R.id.checkBox3);
        checkBoxFrancais = findViewById(R.id.checkBox4);
        buttonEnregistrer = findViewById(R.id.button9);

        // Configuration du gestionnaire d'événements pour le bouton Enregistrer
        buttonEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupérer les valeurs des champs d'entrée
                String nouveauCompte = editTextCompte.getText().toString();
                String nouveauPassword = editTextPassword.getText().toString();

                // Récupérer la sélection du genre
                String nouveauGenre = "";
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == radioButtonHomme.getId()) {
                    nouveauGenre = "Homme";
                } else if (selectedId == radioButtonFemme.getId()) {
                    nouveauGenre = "Femme";
                }

                // Vérifier les cases à cocher
                boolean isArabeSelected = checkBoxArabe.isChecked();
                boolean isFrancaisSelected = checkBoxFrancais.isChecked();

                // Ajouter ici la logique pour enregistrer les modifications du compte

                // Exemple : Afficher une notification toast avec les informations modifiées
                String modificationInfo = "Compte modifié : " + nouveauCompte +
                        "\nNouveau mot de passe : " + nouveauPassword +
                        "\nNouveau genre : " + nouveauGenre +
                        "\nLangues sélectionnées : " + (isArabeSelected ? "Arabe " : "") + (isFrancaisSelected ? "Français" : "");
                Toast.makeText(ModifActivity.this, modificationInfo, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
