package com.example.sampleapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "UserData.db";

    // Table Name
    private static final String TABLE_NAME = "users";

    // Table Columns
    private static final String COL_ID = "id";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // SQL query to create the table
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_EMAIL + " TEXT NOT NULL, " +
                    COL_PASSWORD + " TEXT NOT NULL);";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);  // Create the users table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);  // Drop the table if it exists
        onCreate(db);  // Create the table again
    }

    // Add a new user to the database
    public void addUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertQuery = "INSERT INTO " + TABLE_NAME + " (" + COL_EMAIL + ", " + COL_PASSWORD + ") VALUES ('" + email + "', '" + password + "');";
        db.execSQL(insertQuery);
        db.close();
    }

    // Check if user exists (for login)
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_EMAIL + " = ? AND " + COL_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});
        boolean result = cursor.getCount() > 0;  // If cursor has data, the user exists
        cursor.close();
        db.close();
        return result;
    }
}