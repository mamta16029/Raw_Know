package com.example.mamtasharma.raw_know;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView et_name;
    RadioButton bt,bt2,bt3,bt4;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_name=(TextView)findViewById(R.id.textView6);

        bt=(RadioButton)findViewById(R.id.radioButton);
        bt2=(RadioButton)findViewById(R.id.radioButton2);
        bt3=(RadioButton)findViewById(R.id.radioButton3);
        bt4=(RadioButton)findViewById(R.id.radioButton4);

        next=(Button)findViewById(R.id.button2);
        SharedPreferences studentID= getSharedPreferences("PR1",MODE_PRIVATE);

        String id= studentID.getString("myname", "Nothing found!");
        et_name.setText("Welcome "+id);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),saveData.class);
                startActivity(intent);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),viewData.class);
                startActivity(intent);
                bt.setChecked(false);
                bt3.setChecked(false);
                bt4.setChecked(false);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),updateData.class);
                startActivity(intent);
                bt2.setChecked(false);
                bt4.setChecked(false);
                bt.setChecked(false);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),deleteData.class);
                startActivity(intent);
                bt3.setChecked(false);
                bt2.setChecked(false);
                bt.setChecked(false);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
                bt4.setChecked(false);
                bt3.setChecked(false);
                bt2.setChecked(false);
                bt.setChecked(false);
            }
        });



    }
}
