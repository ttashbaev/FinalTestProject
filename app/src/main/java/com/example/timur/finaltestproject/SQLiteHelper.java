package com.example.timur.finaltestproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "SHOWSTRING";
    private final static int DB_VERSION = 2;
    private final static String TABLE_NAME = "STRING_TABLE";
    private final static String ID = "_id";
    private final static String LETTER = "LETTER";
    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" +
            ID + " INTEGER_PRIMARY_KEY, " +
            LETTER + " TEXT" +
            ");";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
