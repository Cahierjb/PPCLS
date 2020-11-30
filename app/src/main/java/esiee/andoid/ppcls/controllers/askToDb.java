package esiee.andoid.ppcls.controllers;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import esiee.andoid.ppcls.model.User;


public class askToDb {

    private static final String TAG = "TAG";
    private static FirebaseFirestore db;

    static{
        try{
            db = FirebaseFirestore.getInstance();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Connection à la base de donnée échoué");
        }
    }


    public static List<User> getListUsers(){
        List<User> listTemp = null;
        //Select from firebase "SELECT

        //Pour chaque resultat de firebase, créé l'utilisateur et l'ajouté dans la liste

        return listTemp;

    }


    public static void ajoutDonnees(String Firstname, String Lastname, String Age, String valuegenre, String Username, String Email){
        Map<String, Object> user = new HashMap<>();
        user.put("Firstname", Firstname);
        user.put("Lastname", Lastname);
        user.put("Age", Age);
        user.put("Gender", valuegenre);
        user.put("Username", Username);
        user.put("Email", Email);
        db.collection("user").document(Email)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

    public void SauvegardeScoreUser(String Username, int Score){
        boolean result = false;
    }


}