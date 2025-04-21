package com.example.datepicker;
import android.os.Bundle; import
        android.widget.DatePicker; import
        java.util.Calendar; import
        android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override     protected void onCreate(Bundle
                                                  savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker datePicker = findViewById(R.id.datePicker);
        Calendar today = Calendar.getInstance();
// Initialize DatePicker with the current date
        datePicker.init(                 today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int month, int day) {
// Display selected date in Toast message
                        String msg = "You Selected: " + day + "/" + (month + 1) + "/" + year;
                        Toast.makeText(MainActivity.this, msg,
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}