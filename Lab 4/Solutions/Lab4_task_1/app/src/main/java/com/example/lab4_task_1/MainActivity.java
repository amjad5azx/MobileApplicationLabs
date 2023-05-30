package com.example.lab4_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText txt;
    private EditText txt2;
    private EditText txt3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button4);
        txt=findViewById(R.id.editTextTextPersonName);
        txt2=findViewById(R.id.editTextTextPersonName2);
        txt3=findViewById(R.id.editTextTextPersonName3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int num1=Integer.parseInt(""+txt.getText());
                        int num2=Integer.parseInt(""+txt2.getText());
                        int res=num1+num2;
                        txt3.setText(""+res);
                    }
                });
            }
        });

    }
}