package com.cheezycode.sqliterecepie;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mydb";  // Database name
    private static final int DB_VERSION = 1;  // Database version

    // Constructor
    public MyHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table query
        String SQL = "CREATE TABLE PRODUCTS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "DESCRIPTION TEXT, " +
                "PRICE REAL)";
        db.execSQL(SQL);  // Execute table creation

        // Insert default data
        insertData("Jam", "Fruit Jam", 300.0, db);
        insertData("Bread", "Brown Bread", 30.2, db);
        insertData("Corn Flakes", "Flakes", 380.0, db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTS");  // Remove old table
        onCreate(db);  // Recreate table
    }

    // Method to insert data into the database
    public void insertData(String name, String description, double price, SQLiteDatabase database) {
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("DESCRIPTION", description);
        values.put("PRICE", price);
        database.insert("PRODUCTS", null, values);
    }
}
