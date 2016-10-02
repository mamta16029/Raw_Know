package com.example.mamtasharma.raw_know;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mamta Sharma on 10/2/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper
{
    public static final int Version=1;
    public String create="create table "+ Info_Class.Student_Table_Class.Table_Name_ID+"("+ Info_Class.Student_Table_Class.roll_no_ID+" int, "+ Info_Class.Student_Table_Class.name_ID+" TEXT, "+ Info_Class.Student_Table_Class.sem_ID+" int);";
    public DataBaseHelper(Context context) {
        super(context, Info_Class.Student_Table_Class.Data_Base_ID, null, Version);
            }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
    public void save(DataBaseHelper dbH, String roll_no, String name_no, String sem_no)
    {
        SQLiteDatabase SQD=dbH.getWritableDatabase();
        ContentValues CV=new ContentValues();
        CV.put(Info_Class.Student_Table_Class.roll_no_ID,roll_no);
        CV.put(Info_Class.Student_Table_Class.name_ID,name_no);
        CV.put(Info_Class.Student_Table_Class.sem_ID,sem_no);
        SQD.insert(Info_Class.Student_Table_Class.Table_Name_ID,null,  CV);
        //SQD.close();

    }
    public void updateV(DataBaseHelper dbH,String rollS,String nameS, String semS)
    {
        SQLiteDatabase SQD=dbH.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Info_Class.Student_Table_Class.roll_no_ID,rollS);
        contentValues.put(Info_Class.Student_Table_Class.name_ID,nameS);
        contentValues.put(Info_Class.Student_Table_Class.sem_ID,semS);
        SQD.update(Info_Class.Student_Table_Class.Table_Name_ID, contentValues, "roll_no= "+rollS, null);
        //SQD.close();

    }

    public void deleteV(DataBaseHelper dbH,String str)
    {
        SQLiteDatabase SQD=dbH.getWritableDatabase();
        SQD.delete(Info_Class.Student_Table_Class.Table_Name_ID,Info_Class.Student_Table_Class.roll_no_ID + "=" +str,null);
        //SQD.close();
    }


    public Cursor view(DataBaseHelper dbH, String str)
    {
        SQLiteDatabase SQD=dbH.getReadableDatabase();

        Cursor cursor=SQD.rawQuery("Select * FROM "+Info_Class.Student_Table_Class.Table_Name_ID+" Where roll_no= " +str+";",null);
        //SQD.close();
        return cursor;

    }
}
