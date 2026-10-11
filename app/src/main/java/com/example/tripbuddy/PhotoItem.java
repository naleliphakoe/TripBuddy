package com.example.tripbuddy;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PhotoItem {
    public int imageResId;
    private int musicResId;

    public PhotoItem(int imageResId, int musicResId) {
        this.imageResId = imageResId;
        this.musicResId = musicResId;
    }

    public int getImageResId() {return imageResId;}

    public int getMusicResId() {return musicResId;}




}