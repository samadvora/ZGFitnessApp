package com.example.zgfitness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {

    SQLiteDatabase mDB;

    //Defining the Column Names to Inserted in the table, giving the Database & Table name.
    public static final String TABLE_ROW_ID ="_id";
    public static final String TABLE_ROW_NAME ="name";
    public static final String TABLE_ROW_MOBILE_NUMBER ="mobile_number";
    public static final String TABLE_ROW_ADDRESS ="address";
    public static final String TABLE_ROW_CITY ="city";
    public static final String TABLE_ROW_PROVINCE ="province";
    public static final String TABLE_ROW_POSTAL_CODE ="postal_code";

    private static final String DB_NAME = "customers";
    private static final int DB_VERSION = 1;
    private static final String CUSTOMER_DETAILS = "customers_details";


    public DataManager(Context context) {
        //Creating an instance of our internal CustomSQLiteOpenHelper class.
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);

        //Get a writable database.
        mDB = helper.getWritableDatabase();
    }

    //Inserting a row.
    public void insert(String name, String mobile_number, String address, String city, String province, String postal_code){

        //Creating an Insert Query.
        String query = "INSERT INTO " +  CUSTOMER_DETAILS+ " (" +
                TABLE_ROW_NAME + ", " +
                TABLE_ROW_MOBILE_NUMBER + ", "+
                TABLE_ROW_ADDRESS + ", "+
                TABLE_ROW_CITY + ", "+
                TABLE_ROW_PROVINCE + ", "+
                TABLE_ROW_POSTAL_CODE +
                ") " +
                "VALUES (" +
                "'" + name + "'" + ", " +
                "'" + mobile_number + "'" + ", " +
                "'" + address + "'" + ", " +
                "'" + city + "'" + ", " +
                "'" + province + "'" + ", " +
                "'"+ postal_code +"'" +
                ");";

        Log.i("insert() = ", query);
        mDB.execSQL(query);
    }

    //This class is created when our DataManager is initialized.
    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        //This method only runs the first time the database is created.
        @Override
        public void onCreate(SQLiteDatabase db) {

            //Create a table for customers with all the required columns.
            String newTableQueryString = "create table "
                    + CUSTOMER_DETAILS + " ("
                    + TABLE_ROW_ID
                    + " integer primary key autoincrement not null,"
                    + TABLE_ROW_NAME
                    + " text not null,"
                    + TABLE_ROW_MOBILE_NUMBER
                    + " text not null,"
                    + TABLE_ROW_ADDRESS
                    + " text not null,"
                    + TABLE_ROW_CITY
                    + " text not null,"
                    + TABLE_ROW_PROVINCE
                    + " text not null,"
                    + TABLE_ROW_POSTAL_CODE
                    + " text not null);";

            Log.i("create table() = ", newTableQueryString);
            db.execSQL(newTableQueryString);
        }

        //This method only runs when we increment DB_VERSION
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

