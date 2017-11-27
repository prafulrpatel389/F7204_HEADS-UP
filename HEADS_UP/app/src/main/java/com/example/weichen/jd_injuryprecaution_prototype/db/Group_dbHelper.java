package com.example.weichen.jd_injuryprecaution_prototype.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Soyeon on 11/27/2017.
 */

public class Group_dbHelper extends SQLiteOpenHelper {

    public Group_dbHelper(Context context) {
        super(context, Group_db.DB_NAME, null, Group_db.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create Table " + Group_db.GroupEntry.TABLE + " ( " +
                Group_db.GroupEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Group_db.GroupEntry.COL_GROUP_TITLE + " TEXT NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Group_db.GroupEntry.TABLE);
        onCreate(db);
    }
}
