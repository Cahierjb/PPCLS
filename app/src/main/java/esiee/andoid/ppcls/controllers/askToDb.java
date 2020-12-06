package esiee.andoid.ppcls.controllers;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
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
import io.grpc.internal.JsonParser;


public class askToDb {

    private static final String TAG = "TAG";
    private static FirebaseFirestore db;
    private static List<User> listUsers = new ArrayList<User>();

    static{
        try{
            db = FirebaseFirestore.getInstance();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Connection à la base de donnée échoué");
        }
    }


    public static void setListUsers(){
        db.collection("user")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                User userTemp = new User(document.getString("Username"),document.getString("Score"));
                                askToDb.listUsers.add(userTemp);
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public static List<User> getListUsers() {
        return listUsers;
    }

    public static void ajoutDonnees(String Firstname, String Lastname, String Age, String valuegenre, String Username, String Email, String score){
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
                        System.out.println("create");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

    public static void SauvegardeScoreUser(String Email, String Score){
        boolean result = false;
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