package com.example.task65apps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.stream.BaseStream;

public class Contract {

    public static final class SQL implements BaseColumns {
        public static final String TABLE_CONTACTS = "employee";


        public static final String KEY_FNAME = "fname";
        public static final String KEY_LNAME = "lname";
        public static final String KEY_BIRTHDAY = "birthday";
        public static final String KEY_AGE = "age";
        public static final String KEY_URL = "url";
        public static final String KEY_SPECIALTYID = "specialtyid";
        public static final String KEY_SPECIALTY = "specialty";
        public static final String KEY_PRIORITY="priority";

        public static final String TYPE_TEXT="TEXT";
        public static final String TYPE_INTEGER="INTEGER";




  public static final String CREATE_COMMAND="CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +  "(" + _ID + " " + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " + KEY_FNAME + " " + TYPE_TEXT + ", "
                + KEY_LNAME + " " + TYPE_TEXT + ", "
                + KEY_BIRTHDAY + " " + TYPE_TEXT + ", "
                + KEY_AGE + " " + TYPE_TEXT + ", "
                + KEY_URL +" " + TYPE_TEXT + ", "
                + KEY_SPECIALTYID + " " + TYPE_TEXT + ", "
                + KEY_SPECIALTY + " " + TYPE_TEXT +", "
                + KEY_PRIORITY + " " + TYPE_INTEGER + ")";

        public static final String DROP_COMMAND="DROP TABLE IF EXISTS " + TABLE_CONTACTS;


    }

}
