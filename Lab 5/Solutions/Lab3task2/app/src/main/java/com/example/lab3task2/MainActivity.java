package com.example.lab3task2;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



//    Engine
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnC,btnE,btnD;
    private Button btnPlus,btnSub,btnMul,btnDiv;
    private TextView txtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView2);
        GradientDrawable border = new GradientDrawable();
        border.setStroke(5, Color.BLACK);
        border.setShape(GradientDrawable.RECTANGLE);
        textView.setBackground(border);

        txtView=findViewById(R.id.textView2);

        btn0=findViewById(R.id.button0);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn5=findViewById(R.id.button5);
        btn6=findViewById(R.id.button6);
        btn7=findViewById(R.id.button7);
        btn8=findViewById(R.id.button8);
        btn9=findViewById(R.id.button9);
        btnC=findViewById(R.id.button_C);
        btnD=findViewById(R.id.buttonDot);
        btnE=findViewById(R.id.buttonEqual);

        btnPlus=findViewById(R.id.buttonPlus);
        btnSub=findViewById(R.id.buttonMinus);
        btnMul=findViewById(R.id.buttonMul);
        btnDiv=findViewById(R.id.buttonDiv);
        textView.setText("0");

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText(textView.getText().toString()+"9");
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+".");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"-");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"*");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString()+"/");
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString()=="0"){
                    textView.setText("");
                }
                textView.setText("");
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res=calculateExpression(textView.getText().toString());
                textView.setText(""+res);
            }
        });
    }
    private int calculateExpression(String expression) {
        String[] numbers = expression.split("[+\\-*/]");
        String[] operators = expression.split("[0-9]+");

        int total = Integer.parseInt(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            String operator = operators[i];
            switch (operator) {
                case "+":
                    total += number;
                    break;
                case "-":
                    total -= number;
                    break;
                case "*":
                    total *= number;
                    break;
                case "/":
                    total /= number;
                    break;
            }
        }

        return total;
    }
}