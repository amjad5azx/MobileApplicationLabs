package com.example.lab6task3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView settingText,cameraText,sensorText,displayText,appBarText,flashText;
    private ToggleButton toggleButton1;
    private Switch switch1,switch2,switch3,switch4;
    private RadioGroup radioGroup;
    private RadioButton rbtn1,rbtn2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingText=findViewById(R.id.settingText);
        cameraText=findViewById(R.id.cameraText);
        sensorText=findViewById(R.id.sensorText);
        displayText=findViewById(R.id.displayText);
        appBarText=findViewById(R.id.appText);
        flashText=findViewById(R.id.lightText);

        toggleButton1=findViewById(R.id.toggleButton);

        switch1=findViewById(R.id.switch2);
        switch2=findViewById(R.id.switch3);
        switch3=findViewById(R.id.switch4);
        switch4=findViewById(R.id.switch5);

        radioGroup=findViewById(R.id.radioGroup);

        rbtn1=findViewById(R.id.radioButton3);
        rbtn2=findViewById(R.id.radioButton4);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    settingText.setText("Settings On");
                }
                else{
                    settingText.setText("Settings Off");
                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cameraText.setText("Camera On");
                }
                else{
                    cameraText.setText("Camera Off");
                }
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    sensorText.setText("Sensors On");
                }
                else{
                    sensorText.setText("Sensors Off");
                }
            }
        });
        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    displayText.setText("Display On");
                }
                else {
                    displayText.setText("Display Off");
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==rbtn1.getId()){
                    appBarText.setText("AppBar Black");
                } else if (i==rbtn2.getId()) {
                    appBarText.setText("AppBar Blue");
                }
            }
        });
        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    flashText.setText("Flashlight On");
                }
                else{
                    flashText.setText("Flashlight Off");
                }
            }
        });
    }
}