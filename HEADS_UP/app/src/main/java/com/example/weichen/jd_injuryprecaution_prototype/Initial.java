package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Initial extends AppCompatActivity {

    private Button login;
    private Button register;
    private Button about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);


        login = (Button) findViewById(R.id.initial_login);
        register = (Button) findViewById(R.id.initial_register);
        about = (Button) findViewById(R.id.initial_about);
    }

    /**
     * move to login activity
     * @param view
     */
    public void toLoginLayout(View view){
        startActivity(new Intent(Initial.this, Login.class));
    }

    /**
     * move to register activity
     * @param view
     */
    public void toRegisterLayout(View view){
        startActivity(new Intent(Initial.this, Registration.class));
    }

    /**
     * move to about activity
     * @param view
     */
    public void toAboutLayout(View view){
        startActivity(new Intent(Initial.this, About.class));
    }



}
