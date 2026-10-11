package com.example.tripbuddy;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsManager {
    private static final String PREF_NAME = "AppSettings";
    private static final String KEY_THEME = "theme"; // "light" or "dark"
    private static final String KEY_MUSIC_ON = "musicOn";
    private static final String KEY_LANGUAGE = "language";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SettingsManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setTheme(String theme) {
        editor.putString(KEY_THEME, theme);
        editor.apply();
    }

    public String getTheme() {
        return prefs.getString(KEY_THEME, "light");
    }

    public void setMusicOn(boolean on) {
        editor.putBoolean(KEY_MUSIC_ON, on);
        editor.apply();
    }

    public boolean isMusicOn() {
        return prefs.getBoolean(KEY_MUSIC_ON, true);
    }

    public void setLanguage(String lang) {
        editor.putString(KEY_LANGUAGE, lang);
        editor.apply();
    }

    public String getLanguage() {
        return prefs.getString(KEY_LANGUAGE, "en");
    }


}
