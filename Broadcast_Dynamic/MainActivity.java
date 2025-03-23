package com.example.dynamicbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MyDynamicReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Register the receiver dynamically
        myReceiver = new MyDynamicReceiver();
        IntentFilter filter = new IntentFilter("com.example.DYNAMIC_BROADCAST");
        registerReceiver(myReceiver, filter);
    }

    // Method to send a dynamic broadcast
    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.example.DYNAMIC_BROADCAST");
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister the receiver when the activity is destroyed
        unregisterReceiver(myReceiver);
    }
}
