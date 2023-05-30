package com.example.lab7task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private EditText passText;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editTextTextPersonName);
        passText=findViewById(R.id.editTextTextPassword);
        button=findViewById(R.id.button);

        editText.addTextChangedListener(textWatcher);
        passText.addTextChangedListener(textWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Summary.class);
                if(editText.getText().toString().equals("amjad5azx")&&passText.getText().toString().equals("1234")){
                    intent.putExtra("detail","Login Successfully");
                    startActivity(intent);
                }
                else{
                    intent.putExtra("detail","Invalid Username or Password");
                    startActivity(intent);
                }
            }
        });
    }
    private final TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String username=editText.getText().toString().trim();
            String password=passText.getText().toString().trim();
            button.setEnabled(!username.isEmpty() && !password.isEmpty());
        }
    };
}