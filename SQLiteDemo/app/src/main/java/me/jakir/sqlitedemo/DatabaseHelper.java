package me.jakir.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jakir Hossain on 7/23/16.
 * Email: mail@jakir.me
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "friends.db";
    public static final String TABLE_NAME = "friends_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "EMAIL";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null , 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_2  + " TEXT, " + COL_3 + " TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);
        onCreate(db);

    }


    public boolean insertData(String name, String email){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result== -1)
            return false;
        else return true;
    }


    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME, null);

        return res;

    }


    public boolean updateData(String id, String name, String email){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
        return true;

    }

    public Integer deleteData (String id){

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME, "ID  = ?", new String[] {id});

    }



}
