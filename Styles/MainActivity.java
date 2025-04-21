package com.example.styles;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        // Set rounded blue button background
        GradientDrawable roundedBlue = new GradientDrawable();
        roundedBlue.setColor(Color.parseColor("#2196F3"));
        roundedBlue.setCornerRadius(30);
        button2.setBackground(roundedBlue);

        // Set outlined red button background
        GradientDrawable outlinedRed = new GradientDrawable();
        outlinedRed.setColor(Color.TRANSPARENT);
        outlinedRed.setStroke(3, Color.RED);
        outlinedRed.setCornerRadius(20);
        button3.setBackground(outlinedRed);
    }
}
