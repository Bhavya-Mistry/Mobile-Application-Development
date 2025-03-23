package com.example.datepickerexample;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 📅 Calendar Mode DatePicker
        DatePicker datePickerCalendar = findViewById(R.id.datePickerCalendar);
        
        // 🔄 Spinner Mode DatePicker
        DatePicker datePickerSpinner = findViewById(R.id.datePickerSpinner);

        // Get current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // 🔥 Month starts from 0 (Jan = 0, Feb = 1, etc.)
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Set initial date for both DatePickers
        datePickerCalendar.init(year, month, day, (view, selectedYear, selectedMonth, selectedDay) -> {
            // 🔥 Month is zero-based, so add +1 to display correctly
            Toast.makeText(this, "Calendar Mode: " + selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear, Toast.LENGTH_SHORT).show();
        });

        datePickerSpinner.init(year, month, day, (view, selectedYear, selectedMonth, selectedDay) -> {
            Toast.makeText(this, "Spinner Mode: " + selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear, Toast.LENGTH_SHORT).show();
        });
    }
}
