package com.example.mamtasharma.raw_know;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3Activity extends AppCompatActivity {

    EditText msgI,msgE;
    Button store_I,store_E,get_I,get_E;
    TextView tv13,tv28;
    String m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        msgI=(EditText)findViewById(R.id.editText3);
        msgE=(EditText)findViewById(R.id.editText14);
        store_I=(Button)findViewById(R.id.button5);
        store_E=(Button)findViewById(R.id.button);
        get_I=(Button)findViewById(R.id.button6);
        get_E=(Button)findViewById(R.id.button7);

        tv13=(TextView)findViewById(R.id.textView13);
        tv28=(TextView)findViewById(R.id.textView28);
        tv13.setVisibility(View.GONE);
        tv28.setVisibility(View.GONE);

        store_I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveI();

            }
        });

        get_I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrI();

            }
        });

        store_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveE();

            }
        });

        get_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        retrE();
            }
        });
    }

    public void retrI()
    {
        tv28.setText("");
        tv13.setText("");

        try {
            String msg;
            FileInputStream fileInputStream= openFileInput("File_Internal");
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer=new StringBuffer();
            while((msg=bufferedReader.readLine())!= null)
            {
                stringBuffer.append(msg+"\n");
            }
            tv13.setText(stringBuffer.toString());
            tv13.setVisibility(View.VISIBLE);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveI()
    {    tv13.setText("");
        tv28.setText("");
        String msg=msgI.getText().toString();
        String fn="File_Internal";
        try {
            FileOutputStream fileOutputStream= openFileOutput(fn,MODE_PRIVATE);   //so thet no other application can access this file
            fileOutputStream.write(msg.getBytes());
            fileOutputStream.close();
            msgI.setText("");// clear the text area after saving message
            Toast.makeText(getApplicationContext(),"Message saved internally !",Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void retrE()
    {
        tv13.setText("");
        tv28.setText("");
        File root=Environment.getExternalStorageDirectory();
        File txtfile=new File(root.getAbsolutePath()+"ExFile.txt");

        String msg;

        try {
            FileInputStream fileInputStream= new FileInputStream("/sdcard/" + "ExFile.txt");
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();

            while((msg=bufferedReader.readLine())!= null)
            {
                stringBuffer.append(msg+"\n");
            }


        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }


    }

    public void saveE()
    {
        tv13.setText("");
        tv28.setText("");
        String state;
        state= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state))
        {
            File root=Environment.getExternalStorageDirectory();
            if(!root.exists())
            {
                root.mkdir();
                // Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
            }
            File txtFile= new File(root,"ExFile.txt");
            // Toast.makeText(getApplicationContext(),"h1",Toast.LENGTH_SHORT).show();
            String msg=msgE.getText().toString();


            try {
                FileOutputStream fileOutputStream= new FileOutputStream(txtFile);
                fileOutputStream.write(msg.getBytes());
                fileOutputStream.close();
                msgE.setText("");
                //Toast.makeText(getApplicationContext(),"hi2",Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Message Saved on External Storage!",Toast.LENGTH_LONG).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e)
            {
                e.printStackTrace();

            }

        }
        else
        {
            Toast.makeText(getApplicationContext(),"No Memory Free!",Toast.LENGTH_LONG).show();
        }


    }



}
