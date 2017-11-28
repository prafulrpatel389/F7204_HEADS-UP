package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.weichen.jd_injuryprecaution_prototype.db.Group_db;
import com.example.weichen.jd_injuryprecaution_prototype.db.Task_db;
import com.example.weichen.jd_injuryprecaution_prototype.db.Task_dbHelper;

/**
 * Created by preston on 11/12/17.
 */

public class Task extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        final Intent intent = getIntent();
        String[] task_info = intent.getStringExtra("task_info").split(" - ");

        TextView tvDateContent = (TextView) findViewById(R.id.tv_date_content);
        TextView tvTypeContent = (TextView) findViewById(R.id.tv_type_content);

        Button bCancel = (Button) findViewById(R.id.bCancel);
        Button bComplete = (Button) findViewById(R.id.bComplete);

        tvDateContent.setText(task_info[0]);
        tvTypeContent.setText(task_info[1]);

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Task.this, Activities.class));
            }
        });

        bComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Task_dbHelper mHelper = new Task_dbHelper(getBaseContext());

                SQLiteDatabase db = mHelper.getWritableDatabase();
                db.delete(Group_db.GroupEntry.TABLE, Task_db.TaskEntry.COL_TASK_DATE + " = ?", new String[] {intent.getStringExtra("task_info")});
                db.close();

                startActivity(new Intent(Task.this, Activities.class));
            }
        });

    }
}
