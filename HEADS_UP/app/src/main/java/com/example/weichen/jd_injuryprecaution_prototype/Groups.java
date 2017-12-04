package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.weichen.jd_injuryprecaution_prototype.db.Group_db;
import com.example.weichen.jd_injuryprecaution_prototype.db.Group_dbHelper;

import java.util.ArrayList;

public class Groups extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private static final String TAG = "Groups";
    private Group_dbHelper mHelper;
    private ListView mGroupListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);


        //sets toggle of drawer navigation
        mDrawerLayout = (DrawerLayout) findViewById(R.id.groups_drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //sets functions of drawer navigation
        NavigationView topNavigation = (NavigationView) findViewById(R.id.groups_top_navigation);
        topNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(Groups.this, MainActivity.class));
                        break;
                    case R.id.nav_activities:
                        startActivity(new Intent(Groups.this, Activities.class));
                        break;
                    case R.id.nav_status:
                        startActivity(new Intent(Groups.this, Status.class));
                        break;
                    case R.id.nav_articles:
                        startActivity(new Intent(Groups.this, Articles.class));
                        break;
                    case R.id.nav_groups:
                        startActivity(new Intent(Groups.this, Groups.class));
                        break;
                    case R.id.nav_profile:
                        startActivity(new Intent(Groups.this, Profile.class));
                        break;
                    case R.id.nav_setting:
                        startActivity(new Intent(Groups.this, Setting.class));
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(Groups.this, Initial.class));
                        break;
                }
                return true;
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.groups_bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem memuItem = menu.getItem(3);
        memuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_activities:
                        startActivity(new Intent(Groups.this, Activities.class));
                        break;
                    case R.id.action_status:
                        startActivity(new Intent(Groups.this, Status.class));
                        break;
                    case R.id.action_articles:
                        startActivity(new Intent(Groups.this, Articles.class));
                        break;
                    case R.id.action_groups:
                        startActivity(new Intent(Groups.this, Groups.class));
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(Groups.this, Profile.class));
                        break;
                }
                return true;
            }
        });
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        mHelper = new Group_dbHelper(this);
        mGroupListView = (ListView) findViewById(R.id.group_list);
        updateUI();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.group_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_add_group:
                final EditText groupEditText = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("New Group")
                        .setMessage("Add a new Group")
                        .setView(groupEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogue, int which) {
                                String task = String.valueOf(groupEditText.getText());
                                SQLiteDatabase db = mHelper.getWritableDatabase();
                                ContentValues values = new ContentValues();
                                values.put(Group_db.GroupEntry.COL_GROUP_TITLE, task);
                                db.insertWithOnConflict(Group_db.GroupEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                                db.close();
                                updateUI();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(Group_db.GroupEntry.TABLE,
                new String[] {Group_db.GroupEntry.COL_GROUP_TITLE}, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex(Group_db.GroupEntry.COL_GROUP_TITLE);
            taskList.add(cursor.getString(index));
        }

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<String>(this, R.layout.group_item, R.id.group_title, taskList);
            mGroupListView.setAdapter(mAdapter);

        } else {
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }

    public void enterGroupA(View view) {startActivity(new Intent(Groups.this, GroupFunc.class));
    }

    public void leaveGroup(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.group_title);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(Group_db.GroupEntry.TABLE, Group_db.GroupEntry.COL_GROUP_TITLE + " = ?", new String[] {task});
        db.close();
        updateUI();

    }
}
