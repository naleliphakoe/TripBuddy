package com.example.tripbuddy;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.List;

public class TripDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "tripbuddy.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME= "trip_activities";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TRIP_ID = "trip_id";
    private static final String COLUMN_ACTIVITY_NAME = "activity_name";
    private static final String COLUMN_COST = "cost";
    private static final String TABLE_EXPENSES = "custom_expenses";
    private static final String COLUMN_EXPENSE_NAME = "expense_name";
    private static final String COLUMN_AMOUNT = "amount";

    public TripDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    public static void SaveT(EditText dest, double selectedActivityC) {
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACTIVITIES = "CREATE TABLE " + TABLE_NAME + "("+
                COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TRIP_ID + " INTEGER," +
                COLUMN_ACTIVITY_NAME + " TEXT," +
                COLUMN_COST + "cost REAL)";
        db.execSQL(CREATE_ACTIVITIES);

        String CREATE_EXPENSES = "CREATE TABLE " + TABLE_EXPENSES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TRIP_ID + " INTEGER," +
                COLUMN_EXPENSE_NAME + " TEXT," +
                COLUMN_AMOUNT +" REAL)";
        db.execSQL(CREATE_EXPENSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void saveTrip(String destination, List<PhotoItem> activities) {
        SQLiteDatabase db = this.getWritableDatabase();

        SharedPreferences sharedPreferences = null;

        int totalTrips = sharedPreferences.getInt("tripCount", 0);
        totalTrips++;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("tripCount", totalTrips);
        editor.apply();


        if (totalTrips >= 3) {

        }
    }



}
