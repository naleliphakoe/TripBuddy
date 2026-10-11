package com.example.tripbuddy;

import static android.widget.Spinner.*;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

public class TripPlan extends AppCompatActivity {
    EditText Dest;
    EditText Note;
    EditText Exp;
    EditText ExpInput;
    Spinner Acti;
    String[] activities = {"Sightseeing - R500", "Hiking - R200", "Dining - R450", "Museum Tour - R300", "Beach day- R100"};
    int[] activityCosts = {500, 200, 450, 300, 100};
    double selectedActivityC = 0;
    Button SaveT;
    TextView Start;
    TextView End;
    CalendarView Cal;
    TextView Meal;
    ScrollView scrollView;
    boolean isSelectingStartDate = true;
    double subtotal = 0.0, discount = 0.0, finalBudget = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trip_plan);
        Dest = findViewById(R.id.Destination);
        Note = findViewById(R.id.Notes);
        Exp = findViewById(R.id.CExpenses);
        ExpInput = findViewById(R.id.CExpenses);
        Acti = findViewById(R.id.Activities);
        SaveT = findViewById(R.id.STrip);
        Cal = findViewById(R.id.calendarView);
        Start = findViewById(R.id.StartD);
        End = findViewById(R.id.EndD);
        Meal = findViewById(R.id.MealExp);


        Note.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.activities));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Acti.setAdapter(adapter);

        Acti.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculateBudget();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateBudget();
            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateBudget();
            }
        };
        saveTripHistory();

        {
        }
        ;
        Exp.addTextChangedListener(watcher);
        Meal.addTextChangedListener(watcher);

        Start.setOnClickListener(v -> {
            isSelectingStartDate = true;
            Toast.makeText(this, "Select Start Date", Toast.LENGTH_SHORT).show();
        });

        End.setOnClickListener(v -> {
            isSelectingStartDate = false;
            Toast.makeText(this, "Select End Date", Toast.LENGTH_SHORT).show();
        });

        Cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                if (isSelectingStartDate) {
                    Start.setText("Start Date: " + selectedDate);
                } else {
                    End.setText("End Date: " + selectedDate);
                }
            }
        });

        SaveT.setOnClickListener(v -> {
            String destination = Dest.getText().toString();
            calculateBudget();
            Intent intent = new Intent(TripPlan.this, BudgetSummary.class);
            intent.putExtra("Subtotal", subtotal);
            intent.putExtra("Discount", discount);
            intent.putExtra("Total", finalBudget);
            startActivity(intent);
        });
        TripDBHelper.SaveT (Dest, selectedActivityC);
        Toast.makeText(this, "Trip saved", Toast.LENGTH_SHORT).show(); finish();
    };


    private void calculateBudget() {

        subtotal = 0.0;

        int selectedActivityC = Acti.getSelectedItemPosition();

        try {
            String custom = Exp.getText().toString();
            if (!custom.isEmpty()) subtotal += Double.parseDouble(custom);

        String meals = Meal.getText().toString();
        if (!meals.isEmpty()) subtotal += Double.parseDouble(meals);

    }catch(NumberFormatException e) {
        Toast.makeText(this, "Please Enter Number", Toast.LENGTH_SHORT).show();
    }
    int tripCount = getTripCount();
    discount =0.0;
        if(tripCount >=3)discount =subtotal *0.10;

    finalBudget =subtotal -discount;

}
    private void saveTripHistory() {
        SharedPreferences prefs = getSharedPreferences("Trips", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("tripCount", 4);
        editor.apply();

    }
    private void incrementTripCount(){
        SharedPreferences prefs = getSharedPreferences("Trips", MODE_PRIVATE);
        int currentCount = prefs.getInt("tripCount", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("tripCount", currentCount + 1);
        editor.apply();
    }
    private int getTripCount() {

        SharedPreferences prefs = getSharedPreferences("Trips", MODE_PRIVATE);
        int tripCount = 0;
        if (tripCount>= 3){
            finalBudget *=0.9;
        }
        return prefs.getInt("tripCount", 0);

    }
    private void updateBudget() {

    }

}



