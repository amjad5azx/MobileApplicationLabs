package com.example.lab_13_task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        // Programmatically set icons for menu items
        MenuItem homeItem = menu.findItem(R.id.menu_item1);
        homeItem.setIcon(R.drawable.ic_home);

        MenuItem settingsItem = menu.findItem(R.id.menu_item2);
        settingsItem.setIcon(R.drawable.ic_settings);

        MenuItem aboutItem = menu.findItem(R.id.menu_item3);
        aboutItem.setIcon(R.drawable.ic_info);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item1:
                showToast("Home \uD83C\uDFE0");
                return true;
            case R.id.menu_item2:
                showToast("About ℹ️");
                return true;
            case R.id.menu_item3:
                showToast("Setting ⚙️");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}