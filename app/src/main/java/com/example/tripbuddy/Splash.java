package com.example.tripbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {
ImageView splashlo;

private static final int SPLASH_TIME = 7000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
       splashlo= findViewById(R.id.splashlogo);

       new Handler().postDelayed(()->{
            Intent intent = new Intent(Splash.this, MainActivity.class);
            startActivity(intent);
        }, SPLASH_TIME);
        Toast.makeText(Splash.this, "Welcome to Trip Buddy", Toast.LENGTH_SHORT).show();
    }
}