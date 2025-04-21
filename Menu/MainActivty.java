package com.example.menu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonShowMenu;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonShowMenu = findViewById(R.id.button_show_menu);
        textView = findViewById(R.id.textView);

        buttonShowMenu.setOnClickListener(view -> showPopupMenu(view));
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
        popupMenu.getMenu().add("Option 1");
        popupMenu.getMenu().add("Option 2");
        popupMenu.getMenu().add("Option 3");

        popupMenu.setOnMenuItemClickListener(item -> {
            String selectedOption = item.getTitle().toString();
            textView.setText("Selected: " + selectedOption);
            Toast.makeText(MainActivity.this, "You selected " + selectedOption, Toast.LENGTH_SHORT).show();
            return true;
        });

        popupMenu.show();
    }
}
