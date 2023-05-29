package com.example.lab_9_task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText messageEditText;
    private Button sendButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText = findViewById(R.id.editTextTextPersonName);
        sendButton = findViewById(R.id.button);
        textView=findViewById(R.id.textView);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString();

                Date currentTime = new Date();
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                String formattedTime = timeFormat.format(currentTime);
                System.out.println("Current time: " + formattedTime);

                Date currentDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(currentDate);
                System.out.println("Current date: " + formattedDate);


                messageEditText.setText("");

                textView.setText("Message Sent");
                Intent intent = new Intent("DEBUG_INFO");
                intent.putExtra("message", message);
                intent.putExtra("date", formattedDate);
                intent.putExtra("time", formattedTime);
                intent.putExtra("appName", "My Application");
                sendBroadcast(intent);

            }
        });
    }
}