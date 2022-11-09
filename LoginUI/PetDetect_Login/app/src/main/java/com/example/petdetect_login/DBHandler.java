package com.example.petdetect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper{

        private static final String DB_NAME = "PetDetectdb";
        private static final int DB_VERSION = 1;
        private static final String TABLE_NAME = "myAccount";
        private static final String ID_COL = "id";
        private static final String EMAIL_COL = "email";
        private static final String PASSWORD_COL = "password";

        public DBHandler(Context context) {
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

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
            onUpgrade(db, oldVersion, newVersion);
        }


        //Method to read all the emails
     /*   public <EmailList> ArrayList<EmailList> readEmails(){
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursorEmails = db.rawQuery(" SELECT * FROM " + TABLE_NAME, null);
            ArrayList<EmailList> emailListArrayList = new ArrayList<>();

            if (cursorEmails.moveToFirst()) {
                do {
                    emailListArrayList.add(new emailListArrayList(cursorEmails.getString(1),
                            cursorEmails.getString(4),
                            cursorEmails.getString(2),
                            cursorEmails.getString(3)));
                } while (cursorEmails.moveToNext());
            }
            cursorEmails.close();
            return emailListArrayList;

        } */

        //Method to read
        public Cursor getData (String email){
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res =  db.rawQuery( "select * from contacts where email="+email+" ", null );
            return res;
        }

        public boolean UpdateData(String email, String password){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(EMAIL_COL,email);
            contentValues.put(PASSWORD_COL,password);

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

    public void changePassword(String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PASSWORD_COL, password);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }



}
