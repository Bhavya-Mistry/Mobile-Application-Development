package com.example.popupmenu;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowPopup = findViewById(R.id.btnShowPopup);

        btnShowPopup.setOnClickListener(view -> showPopupMenu(view));
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.option_share:
                    Toast.makeText(this, "Share Selected", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.option_edit:
                    Toast.makeText(this, "Edit Selected", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.option_delete:
                    Toast.makeText(this, "Delete Selected", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        });

        popupMenu.show();
    }
}
