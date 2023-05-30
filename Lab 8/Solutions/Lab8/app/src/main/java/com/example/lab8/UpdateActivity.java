package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        try {
            editText=findViewById(R.id.editTextTextPersonName);
            button=findViewById(R.id.button2);
            textView=findViewById(R.id.textView);
            Intent intent=getIntent();
            Bundle bundle=intent.getBundleExtra("Bundle_Data");
            String hint=bundle.getString("hint");
            TimeClass t = (TimeClass) bundle.getSerializable("timeClass");
            textView.setText(hint);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val=editText.getText().toString();
                    if(hint.equals("Enter Hours")){
                        t.setHours(Integer.parseInt(val));
                    }
                    else if (hint.equals("Enter Minutes")) {
                        t.setMin(Integer.parseInt(val));
                    } else if (hint.equals("Enter Seconds")) {
                        t.setSec(Integer.parseInt(val));
                    }
                    Log.d("UpdateActivity", "Updated time: " + t.getTime());
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("updatedTime", t);
                    setResult(RESULT_OK, returnIntent);
                    Log.d("UpdateActivity", "Set result: RESULT_OK");
                    finish();
                }
            });
        } catch (Exception e) {
            Log.e("UpdateActivity", "Error: " + e.getMessage());
        }


    }
}