package com.example.mamtasharma.raw_know;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class viewData extends AppCompatActivity {

    RadioButton rbt5;
    EditText et8,et9,et10;
    String r;
    Context CT=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        rbt5=(RadioButton)findViewById(R.id.radioButton5);
        et8=(EditText)findViewById(R.id.editText8);
        et9=(EditText)findViewById(R.id.editText9);
        et10=(EditText)findViewById(R.id.editText10);

        rbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                r=et8.getText().toString();

                DataBaseHelper dbH=new DataBaseHelper(CT);

                Cursor cr= dbH.view(dbH,r);
                cr.moveToFirst();
                et8.setText(""+cr.getInt(cr.getColumnIndex("roll_no")));
                et9.setText(cr.getString(cr.getColumnIndex("name")));
                et10.setText(""+cr.getInt(cr.getColumnIndex("sem")));

            }
        });


    }
}
