package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private int score;
    private TextView scoreView;

    Typeface gothambold, gothambolditalic, gothambook, gothambookitalic,
            gothamlight, gothamlightitalic, gothammedium, gothammedium_1,
            gothammediumitalic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("user_pass", MODE_PRIVATE);
        score = sharedPreferences.getInt("score", 0);

        scoreView = (TextView)findViewById(R.id.score);
        scoreView.setText(String.valueOf(score));


        gothambold = Typeface.createFromAsset(getAssets(),"gothambold.ttf");
        gothambolditalic = Typeface.createFromAsset(getAssets(),"gothambolditalic.ttf");
        gothambook = Typeface.createFromAsset(getAssets(),"gothambook.ttf");
        gothambookitalic = Typeface.createFromAsset(getAssets(),"gothambookitalic.ttf");
        gothamlight = Typeface.createFromAsset(getAssets(),"gothamlight.ttf");
        gothamlightitalic = Typeface.createFromAsset(getAssets(),"gothamlightitalic.ttf");
        gothammedium = Typeface.createFromAsset(getAssets(),"gothammedium.ttf");
        gothammedium_1 = Typeface.createFromAsset(getAssets(),"gothammedium_1.ttf");
        gothammediumitalic = Typeface.createFromAsset(getAssets(),"gothammediumitalic.ttf");







        //sets toggle of drawer navigation
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //sets functions of drawer navigation
        NavigationView topNavigation = (NavigationView) findViewById(R.id.main_top_navigation);
        topNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        break;
                    case R.id.nav_activities:
                        startActivity(new Intent(MainActivity.this, Activities.class));
                        break;
                    case R.id.nav_status:
                        startActivity(new Intent(MainActivity.this, Status.class));
                        break;
                    case R.id.nav_articles:
                        startActivity(new Intent(MainActivity.this, Articles.class));
                        break;
                    case R.id.nav_groups:
                        startActivity(new Intent(MainActivity.this, Groups.class));
                        break;
                    case R.id.nav_profile:
                        startActivity(new Intent(MainActivity.this, Profile.class));
                        break;
                    case R.id.nav_setting:
                        startActivity(new Intent(MainActivity.this, Setting.class));
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(MainActivity.this, Initial.class));
                        break;
                }
                return true;
            }
        });


        // setting for bottom nav
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem memuItem = menu.getItem(0);
        memuItem.setChecked(true);
        // override for bottom nav functions
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_activities:
                        startActivity(new Intent(MainActivity.this, Activities.class));
                        break;
                    case R.id.action_status:
                        startActivity(new Intent(MainActivity.this, Status.class));
                        break;
                    case R.id.action_articles:
                        startActivity(new Intent(MainActivity.this, Articles.class));
                        break;
                    case R.id.action_groups:
                        startActivity(new Intent(MainActivity.this, Groups.class));
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(MainActivity.this, Profile.class));
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
            startActivity(new Intent(MainActivity.this, Setting.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
