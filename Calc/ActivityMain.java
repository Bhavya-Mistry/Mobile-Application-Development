package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText p1, p2, p3;
    Button b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = findViewById(R.id.n1);
        p2 = findViewById(R.id.n2);
        p3 = findViewById(R.id.n3);
        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);
        b3 = findViewById(R.id.bt3);
        b4 = findViewById(R.id.bt4);
        b5 = findViewById(R.id.bt5);
    }

    public void add(View obj) {
        int n1 = Integer.parseInt(p1.getText().toString());
        int n2 = Integer.parseInt(p2.getText().toString());
        int n3 = n1 + n2;
        p3.setText(String.valueOf(n3));
    }

    public void sub(View obj) {
        int n1 = Integer.parseInt(p1.getText().toString());
        int n2 = Integer.parseInt(p2.getText().toString());
        int n3 = n1 - n2;
        p3.setText(String.valueOf(n3));
    }

    public void mul(View obj) {
        int n1 = Integer.parseInt(p1.getText().toString());
        int n2 = Integer.parseInt(p2.getText().toString());
        int n3 = n1 * n2;
        p3.setText(String.valueOf(n3));
    }

    public void div(View obj) {
        int n1 = Integer.parseInt(p1.getText().toString());
        int n2 = Integer.parseInt(p2.getText().toString());
        int n3 = n1 / n2;
        p3.setText(String.valueOf(n3));
    }

    public void cln(View obj) {
        p1.setText(null);
        p2.setText(null);
        p3.setText(null);
    }
}
