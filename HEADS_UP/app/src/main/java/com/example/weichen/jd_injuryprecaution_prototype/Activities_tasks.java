package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.weichen.jd_injuryprecaution_prototype.db.Group_db;
import com.example.weichen.jd_injuryprecaution_prototype.db.Group_dbHelper;
import com.example.weichen.jd_injuryprecaution_prototype.db.Task_db;
import com.example.weichen.jd_injuryprecaution_prototype.db.Task_dbHelper;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.weichen.jd_injuryprecaution_prototype.R.layout.activity_activities_tasks;

public class Activities_tasks extends Fragment {

    String[] type = new String[] {"Daily Training", "Pre-game Training", "Game Time", "Post-game Recovery","Daily Training", "Pre-game Training", "Game Time", "Post-game Recovery"};
    private FloatingActionButton mFAB;

    EditText etTaskDate;
    Spinner  spTaskType;

    private static final String TAG = "Tasks";
    private Task_dbHelper mHelper;
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view       = inflater.inflate(activity_activities_tasks,container,false);
        final Context context = getActivity();

        mHelper       = new Task_dbHelper(context);

        mTaskListView = (ListView) view.findViewById(R.id.tasks_listView);
        mTaskListView.setClickable(true);

        mFAB = (FloatingActionButton) view.findViewById(R.id.tasks_add);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder rBuilder = new AlertDialog.Builder(context);
                View mView = inflater.inflate(R.layout.activity_new_tasks_popup,null);

                etTaskDate = (EditText) mView.findViewById(R.id.task_date);
                spTaskType = (Spinner) mView.findViewById(R.id.newTasks_spinner);

                final Button bCreate = (Button) mView.findViewById(R.id.task_create);
                bCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String newDate = etTaskDate.getText().toString();
                        String newType = spTaskType.getSelectedItem().toString();

                        // Create new task in the database
                        SQLiteDatabase db = mHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();

                        values.put(Task_db.TaskEntry.COL_TASK_DATE, newDate);
                        values.put(Task_db.TaskEntry.COL_TASK_TYPE, newType);

                        db.insertWithOnConflict(Task_db.TaskEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                        db.close();
                        updateUI();

                        startActivity(new Intent(context, Activities.class));
                    }
                });

                final Button bCancel = (Button) mView.findViewById(R.id.task_cancel);
                bCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(context, Activities.class));
                    }
                });

                rBuilder.setView(mView);
                AlertDialog dialog = rBuilder.create();
                dialog.show();
            }
        });

        updateUI();

        mTaskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Task.class);
                intent.putExtra("task_no", position);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.task_menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    private void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(Task_db.TaskEntry.TABLE,
                new String[]{Task_db.TaskEntry.COL_TASK_DATE}, null, null, null, null, null);

        int index;

        while (cursor.moveToNext()) {
            String date;
//            String type;

            index = cursor.getColumnIndex(Task_db.TaskEntry.COL_TASK_DATE);
            date  = cursor.getString(index);

            taskList.add(date);

//            index = cursor.getColumnIndexOrThrow("type");
//            type  = cursor.getString(index);
//
//            taskList.add(type);

//            taskList.add(date + "\n" + type);
        }

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.task_item, R.id.task_title, taskList);
            mTaskListView.setAdapter(mAdapter);

        } else {
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }

    public void completeTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.task_title);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(Group_db.GroupEntry.TABLE, Task_db.TaskEntry.COL_TASK_DATE + " = ?", new String[] {task});
        db.close();
        updateUI();
    }

}
