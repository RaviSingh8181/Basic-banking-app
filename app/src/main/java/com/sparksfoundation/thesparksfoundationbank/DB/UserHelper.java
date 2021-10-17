package com.sparksfoundation.thesparksfoundationbank.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sparksfoundation.thesparksfoundationbank.DB.UserContract.UserEntry;

public class            UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(12345,'KOMAL KUMARI', 'KUMARIMERI@gmail.com','SFB1234','6205248309', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(58625,'RAVI SINGH', 'ravi@gmail.com','1234','SFB9656859454', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(35754,'LOVELY SINGH', 'lovely@gmail.com','SFB1234','9544740215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(78413,'Khushi singh', 'khushi@gmail.com','SFB1234','9999561539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(48486,'RANJAN KUMAR', 'ranjan@gmail.com','SFB1234','7309565215', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(78514,'RITA SAMBAL', 'sambal@gmail.com','SFB1234','9592591254', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(46854,'RANJAN MODI', 'modi@gmail.com','SFB1234','7655641494', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(65454,'NITISH KUMAR', 'nitish@gmail.com','SFB1234','946641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(69845,'BANTY SINGH', 'singh@gmail.com','SFB1234','9856541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(94513,'UTSAV MUKUL', 'mukul@gmail.com','SFB1234','8764642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(45546,'KOUSHAL BHAIYA', 'bhaiya@gmail.com','SFB1234','7893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}