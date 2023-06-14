package com.example.lab12_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText variableEditText, valueEditText;
    private Button setButton, getButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        variableEditText = findViewById(R.id.variableEditText);
        valueEditText = findViewById(R.id.valueEditText);
        setButton = findViewById(R.id.setButton);
        getButton = findViewById(R.id.getButton);

        sharedPreferences = getSharedPreferences("KeyValuePairs", MODE_PRIVATE);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String variable = variableEditText.getText().toString();
                String value = valueEditText.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(variable, value);
                editor.apply();

                Toast.makeText(MainActivity.this, "Key-Value pair set successfully", Toast.LENGTH_SHORT).show();
            }
        });

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String variable = variableEditText.getText().toString();

                String value = sharedPreferences.getString(variable, "");
                if (value.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Value not found for the key", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Value: " + value, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}