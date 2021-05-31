package com.busur.sketch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mainscreen extends AppCompatActivity {

    EditText email;
    EditText password;
    Button register;
    Button login;
    boolean isEmailValid, isPassValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        register = findViewById(R.id.gotoRegister);
        login = findViewById(R.id.btnLogin);

        SharedPreferences.Editor editor = getSharedPreferences("myPrefs", MODE_PRIVATE ).edit();
        editor.putBoolean("isIntroOpnend", true);
        editor.apply();




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();
            }


        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mainscreen.this, Signup.class);
                startActivity(i);
                finish();

            }
        });
    }

    public void validate() {
        //check if password is < 8 ... return false
        //check if phone is < 10 ... return false
        if (email.getText().toString().isEmpty()) {
            email.setError("Email cannot be empty!");
            isEmailValid = false;
        } else if (email.getText().length() < 8) {
            email.setError("Email is short!");
            isEmailValid = false;
        } else {
            isEmailValid = true;
        }

        if (password.getText().toString().isEmpty()) {
            password.setError("Password cannot be empty!");
            isPassValid = false;
        } else if (password.getText().length() < 8) {
            password.setError("Email is short!");
            isPassValid = false;
        } else {
            isPassValid = true;
        }

        if (isEmailValid && isPassValid) {
            Intent i = new Intent(mainscreen.this, Signup.class);


        }
    }
}