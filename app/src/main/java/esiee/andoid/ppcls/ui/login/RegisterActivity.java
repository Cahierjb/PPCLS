package esiee.andoid.ppcls.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import esiee.andoid.ppcls.R;
import esiee.andoid.ppcls.controllers.askToDb;


public class RegisterActivity extends Activity {
    private static final String TAG = "TAG";
    private FirebaseAuth mAuth;
    private EditText Firstname, Lastname, Age, Email, Username , Password;
    private Button Enregistrer;
    private RadioButton Gender;
    private RadioGroup quelgenre;
    private FirebaseFirestore db;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        Firstname = (EditText) findViewById(R.id.textFirstname);
        Lastname = (EditText) findViewById(R.id.textLastname);
        Age = (EditText) findViewById(R.id.texteAge);
        Email= (EditText) findViewById(R.id.textEmailAddress);
        Username = (EditText) findViewById(R.id.textUsername);
        Password = (EditText) findViewById(R.id.textPassword);
        Enregistrer =(Button) findViewById(R.id.Submit_button);
        quelgenre = (RadioGroup)findViewById(R.id.quelgenre);


        Enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int selected= quelgenre.getCheckedRadioButtonId();
               Gender=(RadioButton) findViewById(selected);
               String valuegenre= Gender.getText().toString();
               System.out.println(valuegenre);
                askToDb.ajoutDonnees(Firstname.getText().toString(),Lastname.getText().toString(),Age.getText().toString(),valuegenre,Username.getText().toString(),Email.getText().toString());
                Register(Email.getText().toString(),Password.getText().toString());
            }
        });
    }


    public void Register(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }




}
