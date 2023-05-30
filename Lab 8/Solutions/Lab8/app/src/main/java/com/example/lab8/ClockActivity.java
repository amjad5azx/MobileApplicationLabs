package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ClockActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private Button button;
    private TextView textView;
    private TimeClass t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        radioGroup=findViewById(R.id.radioGroup);
        radioButton1=findViewById(R.id.radioButton);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton4);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView2);

        Intent intent=new Intent(this,UpdateActivity.class);
        Bundle bundle=new Bundle();
        t=new TimeClass(12,45,45);
        textView.setText(t.getTime());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton1.isChecked()){
                    bundle.putSerializable("timeClass",t);
                    bundle.putString("hint","Enter Hours");
                } else if (radioButton2.isChecked()) {
                    bundle.putSerializable("timeClass",t);
                    bundle.putString("hint","Enter Minutes");

                } else if (radioButton3.isChecked()) {
                    bundle.putSerializable("timeClass",t);
                    bundle.putString("hint","Enter Seconds");
                }
                intent.putExtra("Bundle_Data",bundle);
                startActivityForResult(intent,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            TimeClass updatedTime = (TimeClass) data.getSerializableExtra("updatedTime");
            textView.setText(updatedTime.getTime());
            t.setMin(updatedTime.getMin());
            t.setSec(updatedTime.getSec());
            t.setHours(updatedTime.getHours());
        }

    }
}