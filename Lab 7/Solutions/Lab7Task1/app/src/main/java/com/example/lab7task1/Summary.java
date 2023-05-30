package com.example.lab7task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        textView=findViewById(R.id.textView);

        String msg=getIntent().getStringExtra("detail");
        if(msg!=null){
            textView.setText(msg);
        }
    }
}