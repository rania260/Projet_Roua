package com.example.projetandroidroua;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import kotlinx.coroutines.scheduling.Task;

public class ProfilActivity extends AppCompatActivity {

    private TextView textViewNomCompte;
    private TextView textViewIdUtilisateur;
    private Button buttonSupprimerCompte;
    private Button buttonModifierCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String userId = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("utilisateurs").child(userId);

        // Initialisation des vues
        textViewNomCompte = findViewById(R.id.textView);
        textViewIdUtilisateur = findViewById(R.id.textView2);
        buttonSupprimerCompte = findViewById(R.id.button7);
        buttonModifierCompte = findViewById(R.id.button8);

        // Récupérer les données de l'intent (venant de ConnexionActivity)
        Intent intent = getIntent();
        String nomCompte = intent.getStringExtra("nomCompte");
        String idUtilisateur = intent.getStringExtra("idUtilisateur");

        // Afficher les données dans les TextView
        textViewNomCompte.setText("Nom du compte : " + nomCompte);
        textViewIdUtilisateur.setText("ID de l'utilisateur : " + idUtilisateur);

        // Configuration du gestionnaire d'événements pour le bouton de suppression du compte
        buttonSupprimerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ajoutez ici la logique pour supprimer le compte
                databaseReference.removeValue();
                // Exemple : Afficher une notification toast
                Toast.makeText(ProfilActivity.this, "Compte supprimé", Toast.LENGTH_SHORT).show();

                // Revenir à l'activité principale (MainActivity)
                Intent retourIntent = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(retourIntent);
            }
        });

        // Configuration du gestionnaire d'événements pour le bouton de modification du compte
        buttonModifierCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Modifiez les champs nécessaires dans la base de données
                Map<String, Object> updates = new HashMap<>();
                updates.put("nom", "NouveauNom");
                updates.put("email", "NouvelEmail");

                databaseReference.updateChildren(updates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    // La mise à jour a réussi, effectuez des actions supplémentaires si nécessaire
                                    Toast.makeText(ProfilActivity.this, "Modification réussie", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Si la mise à jour échoue, affichez un message à l'utilisateur.
                                    Toast.makeText(ProfilActivity.this, "Échec de la modification", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });}