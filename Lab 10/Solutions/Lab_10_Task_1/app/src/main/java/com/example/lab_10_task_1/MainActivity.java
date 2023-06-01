package com.example.lab_10_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button stopButton;
    private CheckBox selfStopCheckBox;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        selfStopCheckBox = findViewById(R.id.selfStopCheckBox);
        textView = findViewById(R.id.logTextView);
        textView.append("\n");
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });
    }
    private BroadcastReceiver logReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String logCat = intent.getStringExtra("logCat");
            if (logCat != null) {
                textView.append(logCat);
            }
        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver(logReceiver, new IntentFilter("LOG_UPDATE"));
    }



    @Override
    protected void onStop() {
        super.onStop();
        // Unregister the log receiver
        LocalBroadcastManager.getInstance(this).unregisterReceiver(logReceiver);
    }
    private void startService() {
        Intent serviceIntent = new Intent(this, MyService.class);
        boolean stopSelf = selfStopCheckBox.isChecked();
        System.out.println("StopSelf value:"+stopSelf);
        if (stopSelf) {
            serviceIntent.putExtra("stopSelf", true);
        }
        startService(serviceIntent);
    }
    private void stopService() {
        Intent serviceIntent = new Intent(this, MyService.class);
//        boolean stopSelf = selfStopCheckBox.isChecked();
//        System.out.println("StopSelf value:"+stopSelf);
//        if (stopSelf) {
//            serviceIntent.putExtra("stopSelf", true);
//        }
        stopService(serviceIntent);
    }
}
