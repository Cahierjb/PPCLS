package esiee.andoid.ppcls.controllers;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


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
        List<User> listTemp = Arrays.asList();
        System.out.println("hello");
        DocumentReference docRef = db.collection("user").document("Email");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                System.out.println("hello2");
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        System.out.println("DocumentSnapshot data: " + document.getData());

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        return listTemp;

    }


    public static void ajoutDonnees(String Firstname, String Lastname, String Age, String valuegenre, String Username, String Email,int score){
        boolean result = false;
        Map<String, Object> user = new HashMap<>();
        user.put("Firstname", Firstname);
        user.put("Lastname", Lastname);
        user.put("Age", Age);
        user.put("Gender", valuegenre);
        user.put("Username", Username);
        user.put("Email", Email);
        user.put("Score", score);
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

    public static void SauvegardeScoreUser(String Email, int Score){
        boolean result = false;
        int finalscore = Score;
        Map<String, Object> user = new HashMap<>();
        user.put("Score", Score);
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

    public static User getUser(String email){
        User currentUser = null;

        return currentUser;
    }
    





}