package com.example.tripbuddy;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FullScreen extends AppCompatActivity {
    Button start;
    Button pause;
    Button stop;
    Button Save;
    private MediaPlayer mediaPlayer;
    private ImageView fullImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_screen);
        start = findViewById(R.id.MStart);
        pause = findViewById(R.id.Pause);
        stop = findViewById(R.id.MStop);
        Save = findViewById(R.id.SaveGallery);

        fullImage = findViewById(R.id.fullView);


        int imageResId = getIntent().getIntExtra("imageResId", 0);
        int musicResId = getIntent().getIntExtra("musicResId", 0);


        fullImage.setImageResource(imageResId);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fullImage.startAnimation(fadeIn);

        mediaPlayer = MediaPlayer.create(this, R.raw.missed);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(1.0f, 1.0f);
        mediaPlayer.start();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(FullScreen.this, R.raw.missed);
                    mediaPlayer.setLooping(true);
                }
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(FullScreen.this, R.raw.missed);
                    mediaPlayer.setLooping(true);
                }
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(FullScreen.this, R.raw.missed);
                    mediaPlayer.release();

                }
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!= null) {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }



}