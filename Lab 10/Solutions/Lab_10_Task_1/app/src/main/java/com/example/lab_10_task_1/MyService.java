package com.example.lab_10_task_1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private StringBuilder logCat = new StringBuilder();
    private boolean stopSelf;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
        appendToLog("onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStart()");
        appendToLog("onStart()");

        stopSelf = intent.getBooleanExtra("stopSelf", false);

        if (stopSelf) {
            appendToLog("stopSelf() requested");
        }
        broadcastLog();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
        appendToLog("onDestroy()");
        broadcastLog();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void appendToLog(String message) {
        logCat.append(message).append("\n");
    }

    private void broadcastLog() {
        Intent logIntent = new Intent("LOG_UPDATE");
        logIntent.putExtra("logCat", logCat.toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(logIntent);
        logCat.setLength(0);

        if (stopSelf) {
            stopSelf();
        }
    }

}
