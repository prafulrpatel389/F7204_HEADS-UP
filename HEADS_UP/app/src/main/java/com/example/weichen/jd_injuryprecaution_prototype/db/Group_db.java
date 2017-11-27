package com.example.weichen.jd_injuryprecaution_prototype.db;

import android.provider.BaseColumns;

/**
 * Created by Soyeon on 11/25/2017.
 */

public class Group_db {

    public static final String DB_NAME ="com.example.weichen.jd_injuryprecaution_prototype.db";
    public static final int DB_VERSION = 1;

    public class GroupEntry implements BaseColumns {
        public static final String TABLE = "tasks";
        public static final String COL_GROUP_TITLE = "title";
    }


}