package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by preston on 11/12/17.
 */

public class Task extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Button bCancel = (Button) findViewById(R.id.bCancel);
        Button bComplete = (Button) findViewById(R.id.bComplete);

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Task.this, Activities.class));
            }
        });

        bComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Task.this, Activities.class));
            }
        });

    }
}
