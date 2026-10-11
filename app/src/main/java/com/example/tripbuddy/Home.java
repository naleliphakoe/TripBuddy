package com.example.tripbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {
TextView welcome;
Button gallery;
Button plan;
Button memory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
welcome= findViewById(R.id.Welcome);
gallery = findViewById(R.id.Gallery);
plan= findViewById(R.id.Plan);
memory = findViewById(R.id.Memory);

gallery.setOnClickListener(v->{
    Intent intent= new Intent(Home.this, Gallery.class);
    startActivity(intent);
        });
plan.setOnClickListener(v->{
            Intent intent= new Intent(Home.this, TripPlan.class);
            startActivity(intent);
        });
memory.setOnClickListener(v->{
            Intent intent= new Intent(Home.this, Memories.class);
            startActivity(intent);
        });
    }
}