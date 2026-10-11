package com.example.tripbuddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    EditText Username, Password;
    Button btnLog;
    SharedPreferences sharedPreferences;

    private static final String PREF_NAME = "UserSession";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        btnLog = findViewById(R.id.btnLog);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        if (sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)) {
            startActivity(new Intent(Login.this, Home.class));
                    finish();
                }
        btnLog.setOnClickListener(v -> {
            String username = Username.getText().toString();
            String password = Password.getText().toString();

            if (!username.isEmpty() && !password.isEmpty()) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(KEY_IS_LOGGED_IN, true);
                editor.putString(KEY_USERNAME, username);
                editor.apply();
                startActivity(new Intent(Login.this, Home.class));
                finish();
            } else {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
