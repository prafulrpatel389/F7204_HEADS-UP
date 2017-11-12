package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Articles extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private ListView listView;
    private ArrayList<String> report = new ArrayList<>();



    String[] date = new String[] {"Nov 9, 2017","Nov 8, 2017","Nov 7, 2017", "Oct 27, 2017","Oct 26, 2017" };
    String[] title = new String[] {"One in five US adults still using tobacco products in 2015",
            "Million Hearts® Recognizes the 2017 Hypertension Control Champions",
            "Fentanyl involved in over half of opioid overdose deaths in 10 states",
            "Getting Ahead of the Next Pandemic: Is the World Ready?",
            "New app helps parents track child’s developmental milestones"
    };
    String[] url = new String[] {"https://www.cdc.gov/media/releases/2017/p1109-tobacco-product-usage.html",
            "https://www.cdc.gov/media/releases/2017/p1107-hypertension-control-champs.html",
            "https://www.cdc.gov/media/releases/2017/s1027-fentanyl-deaths.html",
            "https://www.cdc.gov/media/releases/2017/p1026-world-ready.html",
            "https://www.cdc.gov/media/releases/2017/p1024-app-development-milestones.html"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);


        //sets toggle of drawer navigation
        mDrawerLayout = (DrawerLayout) findViewById(R.id.articles_drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //sets functions of drawer navigation
        NavigationView topNavigation = (NavigationView) findViewById(R.id.articles_top_navigation);
        topNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(Articles.this, MainActivity.class));
                        break;
                    case R.id.nav_activities:
                        startActivity(new Intent(Articles.this, Activities.class));
                        break;
                    case R.id.nav_status:
                        startActivity(new Intent(Articles.this, Status.class));
                        break;
                    case R.id.nav_articles:
                        startActivity(new Intent(Articles.this, Articles.class));
                        break;
                    case R.id.nav_groups:
                        startActivity(new Intent(Articles.this, Groups.class));
                        break;
                    case R.id.nav_profile:
                        startActivity(new Intent(Articles.this, Profile.class));
                        break;
                    case R.id.nav_setting:
                        startActivity(new Intent(Articles.this, Setting.class));
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(Articles.this, Initial.class));
                        break;
                }
                return true;
            }
        });
        // setting bottom navigation bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.articles_bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem memuItem = menu.getItem(2);
        memuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_activities:
                        startActivity(new Intent(Articles.this, Activities.class));
                        break;
                    case R.id.action_status:
                        startActivity(new Intent(Articles.this, Status.class));
                        break;
                    case R.id.action_articles:
                        startActivity(new Intent(Articles.this, Articles.class));
                        break;
                    case R.id.action_groups:
                        startActivity(new Intent(Articles.this, Groups.class));
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(Articles.this, Profile.class));
                        break;
                }
                return true;
            }
        });
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);



        // list view
        listView = (ListView)findViewById(R.id.articles_listView);

        for (int i = 0; i < date.length; i++) {
            String value = "\n" +date[i] + "\n\n" + title[i];
            report.add(value);
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, report);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Articles.this, Articles_view.class);
                intent.putExtra( "url", url[position]);
                startActivity(intent);
            }
        });






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
            startActivity(new Intent(Articles.this, Setting.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
