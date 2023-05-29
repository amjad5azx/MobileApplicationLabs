package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class DebugBroadcastReceiver extends BroadcastReceiver {

    private TextView debugTextView;

    public DebugBroadcastReceiver(TextView debugTextView) {
        this.debugTextView = debugTextView;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("DEBUG_INFO")) {
            String date = intent.getStringExtra("date");
            String appName=intent.getStringExtra("appName");
            String time=intent.getStringExtra("time");
            String message = intent.getStringExtra("message");


            String text = date+" "+appName+" "+time+"\t"+ message +"\n";
            debugTextView.append(text);
        }
    }
}