package com.example.tripbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MemoryEdit extends AppCompatActivity {

    EditText MemoryText;
    TextView Memo;

    ImageView MemoryImage;
    Spinner spinnerMusic;
    Button btnSave;
    Button btnTrack;
    Button btnSettings;

    String imagePath = "";
    int musicResId = 0;

    MemoryDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_memory_edit);


                MemoryText = findViewById(R.id.MemoryTxt);
                MemoryImage = findViewById(R.id.DBMemoryImage);
                spinnerMusic = findViewById(R.id.spinnerMusic);
                btnSave = findViewById(R.id.SVMemo);
                btnTrack = findViewById(R.id.TrackT);
                btnSettings = findViewById(R.id.Set);

                dbHelper = new MemoryDBHelper(this);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                        new String[]{"None", "Music A", "Music B"});
                spinnerMusic.setAdapter(adapter);

                btnSave.setOnClickListener(v -> {
                    String text = MemoryText.getText().toString();

                    int musicResId = spinnerMusic.getSelectedItemPosition();
                    Memory memory = new Memory (text, imagePath, musicResId);
                    dbHelper.addMemory(memory);
                    Toast.makeText(this, "Memory saved!", Toast.LENGTH_SHORT).show();
                    finish();
                });
                btnSettings.setOnClickListener(v -> {
                            Intent intent = new Intent(MemoryEdit.this, Settings.class);
                            startActivity(intent);
                        });
            }

}