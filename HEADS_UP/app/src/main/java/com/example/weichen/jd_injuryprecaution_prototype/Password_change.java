package com.example.weichen.jd_injuryprecaution_prototype;

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

        String type, _newPass, _cf_newPass;

        if (oldPass.getText().toString().equals(newPass.getText().toString()) == false) {
            Toast.makeText(Password_change.this, "Passwords are not matched!", Toast.LENGTH_SHORT).show();
        } else {
            _newPass = newPass.getText().toString();
            _cf_newPass = oldPass.getText().toString();
            type = "password";


            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, _newPass, _cf_newPass);
        }


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
