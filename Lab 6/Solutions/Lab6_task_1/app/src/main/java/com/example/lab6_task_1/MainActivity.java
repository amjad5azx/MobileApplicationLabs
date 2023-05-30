package com.example.lab6_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private CheckBox chk1;
    private CheckBox chk2;
    private String txt1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        chk1=findViewById(R.id.checkBox);
        chk2=findViewById(R.id.checkBox2);
        String chkBox1=chk1.getText().toString();
        String chkBox2=chk2.getText().toString();

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk1.isChecked()){
                    if(btn.getText().toString()!=""){
                        txt1+="+"+chkBox1;
                    }
                    else{
                        txt1+=chkBox1;
                    }
                }
                else{
                    txt1=txt1.replace(chkBox1,"");
                    if (txt1.contains("+")){
                        txt1=txt1.replace("+","");
                    }
                }
                btn.setText(txt1);
            }
        });

        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk2.isChecked()){
                    if(btn.getText().toString()!=""){
                        txt1+="+"+chkBox2;
                    }
                    else{
                        txt1+=chkBox2;
                    }
                }
                else{
                    txt1=txt1.replace(chkBox2,"");
                    if (txt1.contains("+")){
                        txt1=txt1.replace("+","");
                    }
                }
                btn.setText(txt1);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, btn.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}