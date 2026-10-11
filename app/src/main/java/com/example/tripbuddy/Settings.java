package com.example.tripbuddy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Settings extends AppCompatActivity {
    Switch switchTheme;
    Switch switchMusic;
    Spinner spinnerLanguage;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        switchTheme = findViewById(R.id.switchTheme);
        switchMusic = findViewById(R.id.switchMusic);
        spinnerLanguage = findViewById(R.id.spinnerLanguage);

        prefs = getSharedPreferences("AppSettings", MODE_PRIVATE);

        switchTheme.setChecked(prefs.getBoolean("darkMode", false));
        switchMusic.setChecked(prefs.getBoolean("musicEnabled", true));

        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("darkMode", isChecked).apply();
            recreate(); // Restart to apply theme
        });

        switchMusic.setOnCheckedChangeListener((buttonView, isChecked) ->
                prefs.edit().putBoolean("musicEnabled", isChecked).apply());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                new String[]{"English", "Spanish"});
        spinnerLanguage.setAdapter(adapter);

        spinnerLanguage.setSelection(prefs.getInt("languageIndex", 0));

        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                prefs.edit().putInt("languageIndex", pos).apply();
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}


