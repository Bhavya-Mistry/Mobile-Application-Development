package com.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        // Execute AsyncTask
        new DownloadTask().execute();
    }

    // AsyncTask class
    private class DownloadTask extends AsyncTask<Void, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Starting Download...");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for (int i = 1; i <= 100; i += 10) {
                try {
                    Thread.sleep(500);  // Simulating a delay
                    publishProgress(i);  // Updating progress
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Download Completed!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);  // Update ProgressBar
            textView.setText("Downloading: " + values[0] + "%");
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            textView.setText(result);
        }
    }
}
