package com.example.lab_6_task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton redB;
    private RadioButton redF;
    private RadioButton greenB;
    private RadioButton greenF;
    private RadioButton blueB;
    private RadioButton blueF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redB=findViewById(R.id.Red);
        redF=findViewById(R.id.RedF);

        greenB=findViewById(R.id.Green);
        greenF=findViewById(R.id.GreenF);

        blueB=findViewById(R.id.Blue);
        blueF=findViewById(R.id.BlueF);

        View.OnClickListener backgroundClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Red:
                        getWindow().getDecorView().setBackgroundColor(Color.RED);
                        break;
                    case R.id.Green:
                        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.Blue:
                        getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                        break;
                }
            }
        };

        View.OnClickListener foregroundClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.GreenF:
                        getWindow().getDecorView().setForeground(new ColorDrawable(Color.GREEN));
                        break;
                    case R.id.BlueF:
                        getWindow().getDecorView().setForeground(new ColorDrawable(Color.BLUE));
                        break;
                    case R.id.RedF:
                        getWindow().getDecorView().setForeground(new ColorDrawable(Color.RED));
                }
            }
        };
        redB.setOnClickListener(backgroundClickListener);
        greenB.setOnClickListener(backgroundClickListener);
        blueB.setOnClickListener(backgroundClickListener);

        redF.setOnClickListener(foregroundClickListener);
        greenF.setOnClickListener(foregroundClickListener);
        blueF.setOnClickListener(foregroundClickListener);
    }
}