package com.example.lab11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private Button createThreadButton;
    private LinearLayout progressContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createThreadButton = findViewById(R.id.createThreadButton);
        progressContainer = findViewById(R.id.progressContainer);

        createThreadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewThread();
            }
        });
    }

    private void createNewThread() {
        ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setMax(100);
        progressBar.setProgress(0);
        progressContainer.addView(progressBar);

        Thread thread = new Thread(new ProgressRunnable(progressBar));
        thread.start();
    }

    private class ProgressRunnable implements Runnable {
        private final ProgressBar progressBar;

        ProgressRunnable(ProgressBar progressBar) {
            this.progressBar = progressBar;
        }

        @Override
        public void run() {
            for (int progress = 0; progress <= 100; progress++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                final int currentProgress = progress;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(currentProgress);
                    }
                });
            }
        }
    }
}