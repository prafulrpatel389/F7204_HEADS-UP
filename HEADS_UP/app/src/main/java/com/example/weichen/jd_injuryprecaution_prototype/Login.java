package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;
    int score;

    private Button login;
    Typeface gothambold, gothammedium;
    private TextView username_login;
    private TextView password_login;
    private TextView forgot_logininfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login = (Button) findViewById(R.id.login_button_login);
        gothambold = Typeface.createFromAsset(getAssets(),"gothambold.ttf");
        login.setTypeface(gothambold);

        gothammedium = Typeface.createFromAsset(getAssets(), "gothammedium.ttf");

        username_login = (TextView) findViewById(R.id.textView);
        password_login = (TextView) findViewById(R.id.textView2);
        forgot_logininfo = (TextView) findViewById(R.id.login_forgot);

        username_login.setTypeface(gothammedium);
        password_login.setTypeface(gothammedium);
       forgot_logininfo.setTypeface(gothammedium);


        username = (EditText) findViewById(R.id.login_input_username);
        if (username.getText().toString().length() == 0) {
            username.setError("Username can't be empty!");
        }
        password = (EditText) findViewById(R.id.login_input_password);
        if (password.getText().toString().length() == 0)
            password.setError("Password can't be empty!");

    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    public void toMainLayout(View view){
        String _username = username.getText().toString();
        String _password = password.getText().toString();
        String type = "login";

        SharedPreferences sharedPreferences = getSharedPreferences("user_pass", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", _username);
        editor.putString("password", _password);
        editor.commit();

        editor.putInt("score", 12);

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, _username, _password);

    }

    public void toForgotLayout(View view) {
        startActivity(new Intent(Login.this, Forgot.class));
    }

}
