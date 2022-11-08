package com.example.petdetect;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandlerRegistration extends SQLiteOpenHelper{

    private static final String DB_NAME = "PetDetectdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "myAccount";
    private static final String ID_COL = "id";
    private static final String EMAIL_COL = "email";
    private static final String PASSWORD_COL = "password";

    public DBHandlerRegistration(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addNewEmail(String emailAddress, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(EMAIL_COL, emailAddress);
        values.put(PASSWORD_COL, password);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
