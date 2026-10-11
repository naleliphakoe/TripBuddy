package com.example.tripbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
TextView welcome;
private static final int MAIN_TIME= 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        welcome = findViewById(R.id.welc);

        new Handler().postDelayed(()->{
        Intent intent =new Intent(MainActivity.this, Registration.class);
        startActivity(intent);
        }, MAIN_TIME);
    }
}