package com.example.weichen.jd_injuryprecaution_prototype.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.weichen.jd_injuryprecaution_prototype.Task;

/**
 * Created by Preston on 11/27/2017.
 */

public class Task_dbHelper extends SQLiteOpenHelper {

    public Task_dbHelper(Context context) {
        super(context, Task_db.DB_NAME, null, Task_db.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create Table " + Task_db.TaskEntry.TABLE + " ( " +
                Task_db.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Task_db.TaskEntry.COL_TASK_DATE + " DATE NOT NULL, " +
                Task_db.TaskEntry.COL_TASK_TYPE + " TYPE NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Task_db.TaskEntry.TABLE);
        onCreate(db);
    }
}
