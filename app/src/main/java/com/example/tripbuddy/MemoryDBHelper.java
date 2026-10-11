package com.example.tripbuddy;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class MemoryDBHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "tripbuddy.db";
        private static final int DB_VERSION = 1;

        private static final String TABLE_MEMORIES = "memories";

        public MemoryDBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE = "CREATE TABLE " + TABLE_MEMORIES + "(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "text TEXT," +
                    "imageView TEXT," +
                    "location TEXT," +
                    "date TEXT," +
                    "mood TEXT," +
                    "musicResId INTEGER)";
            db.execSQL(CREATE_TABLE);
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_MEMORIES);
    }


    public long addMemory(Memory memory) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("text", memory.getText());
            values.put("imageView", String.valueOf(memory.getIntent()));
            values.put("musicResId", memory.getMusicResId());

            long id = db.insert(TABLE_MEMORIES, null, values);
            db.close();
            return id;

    }

}
