package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class newTasks_popup extends AppCompatActivity {

    private static String[] tasks_type = new String[]{"Daily Training", "Pre-Game Training", "Game Time", "Post-Game Recovery"};
    private Spinner type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tasks_popup);

        type = (Spinner) findViewById(R.id.newTasks_spinner);
        ArrayAdapter<String> classAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tasks_type);
        classAdpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(classAdpt);

    }
}
