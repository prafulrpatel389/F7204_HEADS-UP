package com.example.weichen.jd_injuryprecaution_prototype;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private Typeface gothambold, gothambook;
    private TextView version, about_CDC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gothambook = Typeface.createFromAsset(getAssets(), "gothambook.ttf");
        gothambold = Typeface.createFromAsset(getAssets(),"gothambold.ttf");
        version = (TextView) findViewById(R.id.Version);
        about_CDC = (TextView) findViewById(R.id.cdcheadsup);
        version.setTypeface(gothambold);
        about_CDC.setTypeface(gothambook);



    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
