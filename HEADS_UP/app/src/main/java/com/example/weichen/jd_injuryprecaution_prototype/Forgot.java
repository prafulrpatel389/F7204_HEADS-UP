package com.example.weichen.jd_injuryprecaution_prototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Forgot extends AppCompatActivity {

    private EditText username, email, name, newPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        username = (EditText) findViewById(R.id.forgot_username);
        if (username.getText().toString().length() == 0) {
            username.setError("Username can't be empty!");
        }
        email = (EditText) findViewById(R.id.forgot_email);
        if (email.getText().toString().length() == 0) {
            email.setError("Email can't be empty!");
        }
        name = (EditText) findViewById(R.id.forgot_name);
        if (name.getText().toString().length() == 0) {
            name.setError("Name can't be empty!");
        }
        newPass = (EditText) findViewById(R.id.forgot_newPass);
        if (newPass.getText().toString().length() == 0) {
            newPass.setError("New password can't be empty!");
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    public void toResetPass(View view){
        String _username = username.getText().toString();
        String _email = email.getText().toString();
        String _name = name.getText().toString();
        String _newPass = newPass.getText().toString();;
        String type = "resetPass";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, _username, _email, _name, _newPass);


    }



}
