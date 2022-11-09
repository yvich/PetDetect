package com.example.petdetect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandlerRegistration extends SQLiteOpenHelper{

    private static final String DB_NAME = "PetDetectdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "myAccount";
    private static final String ID_COL = "id";
    private static final String EMAIL_COL = "email";
    private static final String PASSWORD_COL = "password";
    private static final String FIRST_NAME_COL = "firstName";
    private static final String LAST_NAME_COL = "lastName";
    private static final String PHONE_NUM_COL = "phoneNumber";

    public DBHandlerRegistration(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + FIRST_NAME_COL + " TEXT,"
                + LAST_NAME_COL + " TEXT,"
                + PHONE_NUM_COL + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    //Method to read
    public Cursor getData (String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where email="+email+" ", null );
        return res;
    }

    public boolean UpdateData(String email, String password, String firstName, String lastName, String phoneNumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(EMAIL_COL,email);
        contentValues.put(PASSWORD_COL,password);
        contentValues.put(FIRST_NAME_COL,password);
        contentValues.put(LAST_NAME_COL,password);
        contentValues.put(PHONE_NUM_COL,password);

        db.update(TABLE_NAME, contentValues, " email = ? ", new String[] {email});
        return true;

    }


    public void addNewEmail(String emailAddress, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(EMAIL_COL, emailAddress);
        values.put(PASSWORD_COL, password);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

}
