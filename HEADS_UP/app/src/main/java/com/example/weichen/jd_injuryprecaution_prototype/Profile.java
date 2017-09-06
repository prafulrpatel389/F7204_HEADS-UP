package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Button password;
    private Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        password = (Button)findViewById(R.id.password_changes);
        edit = (Button)findViewById(R.id.edit_profile);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profile.this, "Profile Editing Successful", Toast.LENGTH_SHORT).show();
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Password_change.class));
            }
        });


        //sets toggle of drawer navigation
        mDrawerLayout = (DrawerLayout) findViewById(R.id.profile_drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //sets functions of drawer navigation
        NavigationView topNavigation = (NavigationView) findViewById(R.id.profile_top_navigation);
        topNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(Profile.this, MainActivity.class));
                        break;
                    case R.id.nav_activities:
                        startActivity(new Intent(Profile.this, Activities.class));
                        break;
                    case R.id.nav_status:
                        startActivity(new Intent(Profile.this, Status.class));
                        break;
                    case R.id.nav_articles:
                        startActivity(new Intent(Profile.this, Articles.class));
                        break;
                    case R.id.nav_groups:
                        startActivity(new Intent(Profile.this, Groups.class));
                        break;
                    case R.id.nav_profile:
                        startActivity(new Intent(Profile.this, Profile.class));
                        break;
                    case R.id.nav_setting:
                        startActivity(new Intent(Profile.this, Setting.class));
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(Profile.this, Initial.class));
                        break;
                }
                return true;
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.profile_bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem memuItem = menu.getItem(4);
        memuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_activities:
                        startActivity(new Intent(Profile.this, Activities.class));
                        break;
                    case R.id.action_status:
                        startActivity(new Intent(Profile.this, Status.class));
                        break;
                    case R.id.action_articles:
                        startActivity(new Intent(Profile.this, Articles.class));
                        break;
                    case R.id.action_groups:
                        startActivity(new Intent(Profile.this, Groups.class));
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(Profile.this, Profile.class));
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
            startActivity(new Intent(Profile.this, Setting.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
