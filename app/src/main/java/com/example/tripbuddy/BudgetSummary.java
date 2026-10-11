package com.example.tripbuddy;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class BudgetSummary extends AppCompatActivity {

    TextView Sub;
    TextView Disc;
    TextView Final;
    Button CustomT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_budget_summary);
        Sub = findViewById(R.id.FSubtotal);
        Disc = findViewById(R.id.FDiscount);
        Final = findViewById(R.id.FinalBudget);
        CustomT = findViewById(R.id.CTrip);

        Intent intent = getIntent();
        double subtotal = intent.getDoubleExtra("subtotal", 0.0);
        double discount = intent.getDoubleExtra("discount", 0.0);
        double total = intent.getDoubleExtra("total", 0.0);

        Sub.setText(String.format("Subtotal: R%.2f", subtotal));
        Disc.setText(String.format("Discount: -R%.2f", discount));
        Final.setText(String.format("Final Total: R%.2f", total));
    }

}
