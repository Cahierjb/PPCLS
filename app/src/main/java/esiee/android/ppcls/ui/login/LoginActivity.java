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

import esiee.andoid.ppcls.R;

public class LoginActivity extends Activity {

    Button signIn, register;
    EditText username,password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn = (Button) findViewById(R.id.signin_button);
        register = (Button) findViewById(R.id.register_button);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


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
            }

        });
    }

}
