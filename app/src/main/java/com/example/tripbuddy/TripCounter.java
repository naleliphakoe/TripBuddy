package com.example.tripbuddy;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;

import java.util.prefs.Preferences;

public class TripCounter {
    private static final String PREF_NAME = "TripData";
    private static final String KEY_TRIP_COUNT = "tripCount";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public TripCounter(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public int getTripCount() {
        return prefs.getInt(KEY_TRIP_COUNT, 0);
    }

    public void incrementTripCount() {

        int count = getTripCount();
        editor.putInt(KEY_TRIP_COUNT, count + 1);
        editor.apply();
    }

    public boolean isEligibleForDiscount() {
        return getTripCount() >= 3;
    }
}
