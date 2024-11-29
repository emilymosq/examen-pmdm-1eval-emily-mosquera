package com.examemily.examenpmdm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.textfield.TextInputLayout;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button botonLogin = findViewById(R.id.loginButton);
        TextInputLayout inputUsername = findViewById(R.id.loginUsername);
        TextInputLayout inputPassword = findViewById(R.id.loginPassword);
        String password = getString(R.string.password);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username = String.valueOf(inputUsername.getEditText().getText()).trim();
               String passwordInput = String.valueOf(inputPassword.getEditText().getText()).trim();

                if(!username.isEmpty() && passwordInput.equals(password)){
                    launchMain();
                } else{
                    Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }

                SharedPreferences sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.apply();
            }
        });
    }

    public void launchMain() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}