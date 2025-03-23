package com.cheezycode.sqliterecepie;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHelper helper = new MyHelper(this);
        SQLiteDatabase database = helper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT NAME, PRICE FROM PRODUCTS", null);

        StringBuilder builder = new StringBuilder();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(0);
                double price = cursor.getDouble(1);
                builder.append("Name: ").append(name).append(", Price: ").append(price).append("\n");
            } while (cursor.moveToNext());
        }

        // Close cursor and database to avoid memory leaks
        cursor.close();
        database.close();

        // Display data in TextView
        TextView textView = findViewById(R.id.txtData);
        textView.setText(builder.toString());
    }
}
