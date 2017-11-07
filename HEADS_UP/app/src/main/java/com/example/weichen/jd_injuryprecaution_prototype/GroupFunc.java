package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Soyeon on 11/6/2017.
 */

public class GroupFunc extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_func);

        fab = (FloatingActionButton)findViewById(R.id.groups_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder rBuilder = new AlertDialog.Builder(GroupFunc.this);
                View mView = getLayoutInflater().inflate(R.layout.new_group_add, null);
                final Button button = (Button) mView.findViewById(R.id.new_group_button);
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

}
