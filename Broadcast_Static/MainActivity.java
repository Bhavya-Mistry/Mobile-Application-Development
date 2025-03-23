package com.example.broadcastcustomintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    

    // Method to send a custom broadcast
    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.CUSTOM_INTENT");
        sendBroadcast(intent);
        Toast.makeText(this, "Custom Intent Broadcasted", Toast.LENGTH_SHORT).show();
    }
}
