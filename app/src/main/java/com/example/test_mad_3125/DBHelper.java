package com.example.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBName = "ParkingDB";
    public static final String TBName_UserInfo = "UserInfo";

    public DBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            String CREATE_TABLE = "CREATE TABLE " + TBName_UserInfo +
                    "(Name varchar(100), Phone varchar(20)," +
                    "Email varchar(50) PRIMARY KEY, Password varchar(20)," +
                    "DOB varchar(20))";

            Log.v("DBHelper",CREATE_TABLE);

            sqLiteDatabase.execSQL(CREATE_TABLE);

        }catch(Exception e){
            Log.e("DBHelper",e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int olderVersion, int newerVersion) {
        try{
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBName_UserInfo);

            onCreate(sqLiteDatabase);

        }catch(Exception e){
            Log.e("DBHelper", e.getMessage());
        }
    }
}
