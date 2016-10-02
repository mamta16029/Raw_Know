package com.example.mamtasharma.raw_know;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class updateData extends AppCompatActivity {

    RadioButton rbt6;
    EditText et11,et12,et13;
    Button bt10;
    String r,n,s;
    Context CT=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        rbt6=(RadioButton)findViewById(R.id.radioButton6);
        et11=(EditText)findViewById(R.id.editText11);
        et12=(EditText)findViewById(R.id.editText12);
        et13=(EditText)findViewById(R.id.editText13);
        bt10=(Button)findViewById(R.id.button10);

        rbt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r=et11.getText().toString();
                DataBaseHelper dbHelper=new DataBaseHelper(CT);
                Cursor CR= dbHelper.view(dbHelper,r);
                CR.moveToFirst();
                et11.setText(""+CR.getInt(CR.getColumnIndex("roll_no")));
                et12.setText(CR.getString(CR.getColumnIndex("name")));
                et13.setText(""+CR.getInt(CR.getColumnIndex("sem")));

            }
        });

        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dbHelper=new DataBaseHelper(CT);
                n=et12.getText().toString();
                s=et13.getText().toString();


                et11.setText("");
                et12.setText("");
                et13.setText("");

                dbHelper.updateV(dbHelper,r,n,s);
                Toast.makeText(getApplicationContext(),"Record Of The Student Updated!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
