package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GroupFunc extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_func);

        fab = (FloatingActionButton)findViewById(R.id.membersToadd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder rBuilder = new AlertDialog.Builder(GroupFunc.this);
                View mView = getLayoutInflater().inflate(R.layout.members_to_add, null);
                final Button button = (Button) mView.findViewById(R.id.cancel_button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(GroupFunc.this, GroupFunc.class));
                    }
                });
                rBuilder.setView(mView);
                AlertDialog dialog = rBuilder.create();
                dialog.show();
            }
        });

        //sets toggle of drawer navigation
        mDrawerLayout = (DrawerLayout) findViewById(R.id.group_func_drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //sets functions of drawer navigation
        NavigationView topNavigation = (NavigationView) findViewById(R.id.group_func_top_navigation);
        topNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(GroupFunc.this, MainActivity.class));
                        break;
                    case R.id.nav_activities:
                        startActivity(new Intent(GroupFunc.this, Activities.class));
                        break;
                    case R.id.nav_status:
                        startActivity(new Intent(GroupFunc.this, Status.class));
                        break;
                    case R.id.nav_articles:
                        startActivity(new Intent(GroupFunc.this, Articles.class));
                        break;
                    case R.id.nav_groups:
                        startActivity(new Intent(GroupFunc.this, Groups.class));
                        break;
                    case R.id.nav_profile:
                        startActivity(new Intent(GroupFunc.this, Profile.class));
                        break;
                    case R.id.nav_setting:
                        startActivity(new Intent(GroupFunc.this, Setting.class));
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(GroupFunc.this, Initial.class));
                        break;
                }
                return true;
            }
        });

        // setting for bottom nav
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.group_func_bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem memuItem = menu.getItem(0);
        memuItem.setChecked(true);
        // override for bottom nav functions
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_activities:
                        startActivity(new Intent(GroupFunc.this, Activities.class));
                        break;
                    case R.id.action_status:
                        startActivity(new Intent(GroupFunc.this, Status.class));
                        break;
                    case R.id.action_articles:
                        startActivity(new Intent(GroupFunc.this, Articles.class));
                        break;
                    case R.id.action_groups:
                        startActivity(new Intent(GroupFunc.this, Groups.class));
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(GroupFunc.this, Profile.class));
                        break;
                }
                return true;
            }
        });
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mToggle.onOptionsItemSelected(item)){
            return  true;
        } else if (id == R.id.actionBar_setting){
            startActivity(new Intent(GroupFunc.this, Setting.class));
        }
        return super.onOptionsItemSelected(item);
    }






}
