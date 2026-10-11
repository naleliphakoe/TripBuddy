package com.example.tripbuddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Memories extends AppCompatActivity {
private RecyclerView recyclerView;
private PhotoAdapter photoAdapter;
private List<PhotoItem> photoItemList;
private Button BackTo;
private static final List <PhotoItem> savedGallery = new ArrayList<>();

    public Memories(String text, String imagePath, int musicResId) {

    }

    public static List<PhotoItem> getMemoryList(){return savedGallery;}
    public static void addToGallery(PhotoItem item){savedGallery.add(item);}


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_memories);

recyclerView = findViewById(R.id.photoGrid);
int numberOfColums = 2;
BackTo = findViewById(R.id.BackTo);

recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColums));
photoItemList = new ArrayList<>();

photoItemList.add(new PhotoItem(R.drawable.jumping, R.raw.missed));
photoItemList.add(new PhotoItem(R.drawable.ski, R.raw.morning));
photoItemList.add(new PhotoItem(R.drawable.snowfight, R.raw.myself));
photoItemList.add(new PhotoItem(R.drawable.surfing, R.raw.purple));
photoItemList.add(new PhotoItem(R.drawable.view, R.raw.claim));


photoAdapter =new PhotoAdapter(this, photoItemList);
recyclerView.setAdapter(photoAdapter);
BackTo.setOnClickListener(v -> finish());
    }
    }


