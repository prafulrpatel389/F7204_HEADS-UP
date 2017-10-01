package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password_change extends AppCompatActivity {

    private Button button;
    EditText oldPass, newPass, cf_newPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        button = (Button) findViewById(R.id.password_change_button);

        oldPass = (EditText) findViewById(R.id.oldPass);
        newPass = (EditText) findViewById(R.id.newPass);
        cf_newPass = (EditText) findViewById(R.id.cf_newPass);

    }

    public void pass_change(View view) {

        String type, _newPass, _oldPass;

        if (newPass.getText().toString().equals(cf_newPass.getText().toString()) == false) {
            Toast.makeText(Password_change.this, "Passwords are not matched!", Toast.LENGTH_SHORT).show();
        } else {

            _oldPass = oldPass.getText().toString();
            _newPass = newPass.getText().toString();

            type = "password";

            SharedPreferences sharedPreferences = getSharedPreferences("user_pass", Context.MODE_PRIVATE);


            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, _oldPass, _newPass, sharedPreferences.getString("username", ""));
        }


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
