package com.harsh.nandy.cancerantidote;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by popla on 25-03-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private  static final String DATABASE_NAME="CnacerAntiDote.db";
    private static final String TABLE_NAME="Book_Ambulance";
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE"+TABLE_NAME+"(ID PRIMARY KEY AUTOINCREMENT,HOSPITALS TEXT,STATE TEXT,AVAIL_AMBULANCE INTEGER)");
      db=getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor getdata(String state)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query  ="SELECT * FROM"+TABLE_NAME+"WHERE STATE='"+state+"'";
        Cursor cursor=db.rawQuery(query,null);

        return cursor;
    }

}
