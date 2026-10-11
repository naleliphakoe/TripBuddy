package com.example.tripbuddy;

import android.content.Intent;

public class Memory {
    private String text;
    private String intent; // Assuming this is used to handle the image
    private int musicResId;

    // Constructor
    public Memory(String text, String intent, int musicResId) {
        this.text = text;
        this.intent = intent;
        this.musicResId = musicResId;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getIntent() {
        return intent;
    }


    // Getter and Setter for musicResId
    public int getMusicResId() {
        return musicResId;
    }

    public void setMusicResId(int musicResId) {
        this.musicResId = musicResId;
    }
}

