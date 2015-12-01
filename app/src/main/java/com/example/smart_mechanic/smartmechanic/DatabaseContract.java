package com.example.smart_mechanic.smartmechanic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Mary on 11/5/2015.
 */
public final class DatabaseContract {


    private static final String DATABASE_NAME = "CarSounds.db";
    private static final int DBASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String LONG_TYPE = " LONG";
    private static final String DOUBLE_TYPE = " DOUBLE";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private static abstract class CarTypeEntries implements BaseColumns {
        public static final String TABLE_NAME = "Car";
        public static final String _ID = "ID";
        public static final String MAKE = "Make";
        public static final String MODEL = "Model";
        public static final String YEAR = "Year";
        public static final String POSITION = "Position";
        public static final String[] ALLCOLUMNS = {_ID,MAKE,MODEL,YEAR,POSITION};
    }

    private static abstract class Fingerprints implements BaseColumns {
        public static final String TABLE_NAME = "Fingerprints";
        public static final String _ID = "ID";
        public static final String CAR_ID = "CAR_ID";
        public static final String[] FreqCount = {"FC0","FC1","FC2","FC3",
                "FC4","FC5","FC6","FC7","FC8","FC9","FC10","FC11","FC12","FC13",
                "FC14","FC15","FC16","FC17","FC18","FC19","FC20","FC21","FC22","FC23",
                "FC24","FC25","FC26","FC27","FC28","FC29","FC30","FC31","FC32","FC33",
                "FC34","FC35","FC36","FC37","FC38","FC39","FC40","FC41","FC42","FC43",
                "FC44","FC45","FC46","FC47"};
        public static final String shortProblem = "ShortProblem";
        public static final String longProblem = "LongProblem";
    }
    private static final String SQL_CREATE_CAR_TABLE =
            "CREATE TABLE " + CarTypeEntries.TABLE_NAME + " (" +
                    CarTypeEntries._ID + " INTEGER PRIMARY KEY," +
                    CarTypeEntries.MAKE + TEXT_TYPE + COMMA_SEP +
                    CarTypeEntries.MODEL + TEXT_TYPE + COMMA_SEP +
                    CarTypeEntries.YEAR + INT_TYPE + COMMA_SEP +
                    CarTypeEntries.POSITION + INT_TYPE +
                    ");";
    private static final String SQL_CREATE_FINGERPRINT_TABLE =
            "CREATE TABLE " + Fingerprints.TABLE_NAME + " (" +
                    Fingerprints._ID + " INTEGER PRIMARY KEY," +
                    Fingerprints.shortProblem + TEXT_TYPE + COMMA_SEP +
                    Fingerprints.longProblem + TEXT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[0] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[1] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[2] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[3] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[4] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[5] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[6] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[7] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[8] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[9] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[10] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[11] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[12] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[13] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[14] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[15] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[16] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[17] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[18] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[19] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[20] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[21] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[22] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[23] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[24] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[25] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[26] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[27] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[28] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[29] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[30] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[31] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[32] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[33] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[34] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[35] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[36] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[37] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[38] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[39] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[40] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[41] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[42] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[43] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[44] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[45] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[46] + INT_TYPE + COMMA_SEP +
                    Fingerprints.FreqCount[47] + INT_TYPE + COMMA_SEP +
                    Fingerprints.CAR_ID + " INTEGER, FOREIGN KEY " +
                    Fingerprints.CAR_ID + " REFERENCES " +
                    CarTypeEntries.TABLE_NAME + "(" + CarTypeEntries._ID + ")";


    private DatabaseHelper myDBHelper;
    private static SQLiteDatabase db;

    private Context context;

    public DatabaseContract(Context ctx){
        this.context = ctx;
        myDBHelper = new DatabaseHelper(ctx);
    }
    public DatabaseContract open(){
       db = myDBHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        myDBHelper.close();
    }

    public static class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DBASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(SQL_CREATE_CAR_TABLE);
            db.execSQL(SQL_CREATE_FINGERPRINT_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        }



        //query to get all supported makes for chooser
        public Cursor getMakes(){
            String[] columns = new String[0];
            columns[0] = CarTypeEntries.MAKE;
            Cursor c = db.query(CarTypeEntries.TABLE_NAME, columns,null,null,CarTypeEntries.MAKE,null,null);
            return c;
        }

        //query to get supported models after choosing make
        public Cursor getModels(String Make){
            String where = CarTypeEntries.MAKE + " = " + Make;
            String[] columns = new String[0];
            columns[0] = CarTypeEntries.MODEL;
            Cursor m = db.query(CarTypeEntries.TABLE_NAME, columns,null,null,null,null,null);
            return m;
        }

        //query to get unique car id based on make, model, year and recording position
        public Cursor getCarID(String Make, String Model,int year, int position){
            Cursor c;
            String where = CarTypeEntries.MAKE + " = " + Make + ", " +
                    CarTypeEntries.MODEL + " = " + Model + ", " +
                    CarTypeEntries.YEAR + " = " + year + ", " +
                    CarTypeEntries.POSITION + " = " + position;
            String[] columns = new String[0];

            columns[0] = CarTypeEntries._ID;
            c = db.query(CarTypeEntries.TABLE_NAME, columns, where, null,null, null,null);
            return c;
        }

        //query to get all fingerprints for a specific car and recording position
        public Cursor getPossibles(int carID){
            String where = Fingerprints.CAR_ID + " = " + carID;
            String[] columns = Fingerprints.FreqCount;
            columns[48] = Fingerprints._ID;
            columns[49] = Fingerprints.shortProblem;
            columns[50] = Fingerprints.longProblem;
            Cursor p = db.query(Fingerprints.TABLE_NAME,columns,where,null,null,null,null);
            return p;
        }
    }


}