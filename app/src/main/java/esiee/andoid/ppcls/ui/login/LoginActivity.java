package esiee.andoid.ppcls.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import esiee.andoid.ppcls.R;

public class LoginActivity extends Activity {

    Button signIn, register;
    EditText Email,password;
    private FirebaseAuth mAuth;
    private static final String TAG = "TAG";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn = (Button) findViewById(R.id.signin_button);
        register = (Button) findViewById(R.id.register_button);
        Email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

       /* register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Asking to DB if we have an user with this name, if yes, get password and compare them with the pasw given by user
                boolean canConnect = askToDb.userExist(username.getText().toString(), password.getText().toString());
                if (canConnect = true){
                  //  currentUser =  askToDb.getUser();
                }

            }
        });*/

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Enregistrement(username.getText().toString(),password.getText().toString());
                SignIn(Email.getText().toString(),password.getText().toString());
            }

        });
    }

    public void SignIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
