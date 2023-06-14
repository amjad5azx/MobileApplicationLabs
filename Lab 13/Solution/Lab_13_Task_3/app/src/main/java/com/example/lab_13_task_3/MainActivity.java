package com.example.lab_13_task_3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.menu_item_home:
                showToast("Home selected");
                return true;
            case R.id.menu_item_settings:
                showToast("Settings selected");
                return true;
            case R.id.menu_item_about:
                showToast("About selected");
                return true;
            case R.id.menu_item_share:
                showShareDialog();
                return true;
            case R.id.menu_item_rate:
                showRateAppDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);

        View toastView = toast.getView();
        if (toastView != null && toastView instanceof LinearLayout) {
            LinearLayout toastLayout = (LinearLayout) toastView;
            ImageView imageView = new ImageView(this);
            toastLayout.addView(imageView, 0);
        }

        toast.show();
    }

    private void showShareDialog() {
        final String[] shareOptions = { "Email", "SMS", "Social Media" };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Share App")
                .setItems(shareOptions, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectedOption = shareOptions[which];
                        showToast("Shared via " + selectedOption);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
    private void showRateAppDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Rate App")
                .setMessage("Enjoying the app? Please take a moment to rate it!")
                .setPositiveButton("Rate Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Implement the logic to handle "Rate Now" button click
                        showToast("Thanks for rating!");
                    }
                })
                .setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

}
