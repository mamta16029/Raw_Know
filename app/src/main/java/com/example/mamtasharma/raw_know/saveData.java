package com.example.mamtasharma.raw_know;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class saveData extends AppCompatActivity {

    EditText et4,et5,et6;
    Button bt8;
    String r,n,s;
    Context CT=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
        et4=(EditText)findViewById(R.id.editText4);
        et5=(EditText)findViewById(R.id.editText5);
        et6=(EditText)findViewById(R.id.editText6);
        bt8=(Button)findViewById(R.id.button8);

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r=et4.getText().toString();
                n=et5.getText().toString();
                s=et6.getText().toString();

                DataBaseHelper dbHelper=new DataBaseHelper(CT);
                dbHelper.save(dbHelper,r,n,s);
                Toast.makeText(getBaseContext(),"One Record Saved!",Toast.LENGTH_SHORT).show();
                et4.setText("");
                et5.setText("");
                et6.setText("");
                dbHelper.close();


            }
        });


    }
}
