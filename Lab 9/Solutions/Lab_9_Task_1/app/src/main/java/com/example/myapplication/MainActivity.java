package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DebugBroadcastReceiver debugReceiver;
    private TextView debugTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        debugTextView = findViewById(R.id.debugTextView);
        debugTextView.setMovementMethod(new ScrollingMovementMethod());
        debugReceiver = new DebugBroadcastReceiver(debugTextView);
        IntentFilter intentFilter = new IntentFilter("DEBUG_INFO");
        registerReceiver(debugReceiver, intentFilter);
    }
}