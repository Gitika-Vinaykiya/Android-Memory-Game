package com.example.androidprojectmemorygame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String ID = "ID";
    public static final String PLAYER_NAME = "PLAYER_NAME";
    public static final String PLAYER_TABLE = "PLAYER_TABLE";

    DatabaseHelper(Context context){
        super(context,PLAYER_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable = "CREATE TABLE  " + PLAYER_TABLE + "  ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PLAYER_NAME + " TEXT)";
        db.execSQL(CreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PLAYER_TABLE );
        onCreate(db);
    }

    public  boolean addrecord(customerModel customermodel){
        SQLiteDatabase db = this.getWritableDatabase();
        //contentvalues
        ContentValues cv = new ContentValues();
        cv.put(PLAYER_NAME, customermodel.getName());
        long insert = db.insert(PLAYER_TABLE, null,cv);

        if(insert == -1){
            return false;
        }
        return true;
    }


    public List<customerModel> getalldata(){
        List<customerModel> display = new ArrayList<>();
        String query = "SELECT * FROM " + PLAYER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        //cursor
        Cursor c = db.rawQuery(query, null);
        if(c.moveToFirst()){
            do{
                int playerID = c.getInt(0);
                String playerName = c.getString(1);

                customerModel newplayer = new customerModel(playerID,playerName);
               display.add(newplayer);
            }while(c.moveToNext());
        }

        c.close();
        db.close();

        return display;
    }
    public Integer delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(PLAYER_TABLE,"ID = ? ", new String[]{id});

    }
}
