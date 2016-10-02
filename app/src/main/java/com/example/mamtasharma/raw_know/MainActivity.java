package com.example.mamtasharma.raw_know;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt3,bt4;
    EditText et_Roll,et_Pass;
    String roll,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt3=(Button)findViewById(R.id.button3);
        bt4=(Button)findViewById(R.id.button4);

        et_Pass=(EditText) findViewById(R.id.editText2);
        et_Roll=(EditText) findViewById(R.id.editText);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll=et_Roll.getText().toString();
                pass=et_Pass.getText().toString();

                SharedPreferences student_Name= getSharedPreferences("PR1",MODE_PRIVATE);

                SharedPreferences.Editor editor= student_Name.edit();
                editor.putString("myname", roll);
                editor.commit();


                Toast.makeText(getApplicationContext(),"Values Saved!",Toast.LENGTH_LONG).show();

                et_Roll.setText("");
                et_Pass.setText("");

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);

            }
        });
    }
}
