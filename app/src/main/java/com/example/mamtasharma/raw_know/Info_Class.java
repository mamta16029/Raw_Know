package com.example.mamtasharma.raw_know;

import android.provider.BaseColumns;

/**
 * Created by Mamta Sharma on 10/2/2016.
 */

public class Info_Class
{
    public Info_Class()
    {

    }

    public static abstract class Student_Table_Class implements BaseColumns
    {
        public static final String roll_no_ID ="roll_no";
        public static final String name_ID ="name";
        public static final String sem_ID ="sem";
        public static final String Data_Base_ID="DataBase";
        public static final String Table_Name_ID="TableName";

    }

}
