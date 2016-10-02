package com.example.mamtasharma.raw_know;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deleteData extends AppCompatActivity {
    EditText et7;
    Button bt9;
    String r;
    Context CT=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        et7=(EditText)findViewById(R.id.editText7);
        bt9=(Button)findViewById(R.id.button9);

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r=et7.getText().toString();
                et7.setText("");

                DataBaseHelper dbH=new DataBaseHelper(CT);
                dbH.deleteV(dbH,r);
                if(r!=null)
                    Toast.makeText(getApplicationContext(),"Record Deleted!",Toast.LENGTH_SHORT).show();



            }
        });
    }
}
