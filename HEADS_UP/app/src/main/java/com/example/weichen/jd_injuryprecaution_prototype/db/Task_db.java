package com.example.weichen.jd_injuryprecaution_prototype.db;

import android.provider.BaseColumns;

/**
 * Created by Preston on 11/27/2017.
 */

public class Task_db {

    public static final String DB_NAME ="com.example.weichen.jd_injuryprecaution_prototype.db.tasks";
    public static final int DB_VERSION = 1;

    public class TaskEntry implements BaseColumns {
        public static final String TABLE = "tasks";
        public static final String COL_TASK_DATE = "date";
        public static final String COL_TASK_TYPE = "type";
    }



}
