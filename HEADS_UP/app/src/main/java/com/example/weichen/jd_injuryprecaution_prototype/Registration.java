package com.example.weichen.jd_injuryprecaution_prototype;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    private EditText name;
    private EditText username;
    private EditText email;
    private EditText zipcode;
    private EditText password;
    private EditText cf_password;
    private Button register1;
    private Typeface gothambold, gothamlight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gothamlight = Typeface.createFromAsset(getAssets(), "gothamlight.ttf");
        gothambold = Typeface.createFromAsset(getAssets(), "gothambold.ttf");


        name = (EditText) findViewById(R.id.registration_input_name);
        if (name.getText().toString().length() == 0) {
            name.setError("Name can't be empty!");
        }
        username = (EditText) findViewById(R.id.registration_input_username);
        if (username.getText().toString().length() == 0) {
            username.setError("Username can't be empty!");
        }
        email = (EditText) findViewById(R.id.registration_input_email);
        if (email.getText().toString().length() == 0) {
            email.setError("Email can't be empty!");
        }

        zipcode = (EditText) findViewById(R.id.registration_input_zipcode);
        if (zipcode.getText().toString().length() == 0) {
            zipcode.setError("Zip Code can't be empty!");
        }

        password = (EditText) findViewById(R.id.registration_input_password);
        if (password.getText().toString().length() == 0) {
            password.setError("Password can't be empty!");
        }
        cf_password = (EditText) findViewById(R.id
                .registration_input_passwordConfirm);
        if (cf_password.getText().toString().length() == 0) {
            cf_password.setError("Password can't be empty!");
        }

        register1 = (Button) findViewById(R.id.registration_button_register);
        register1.setTypeface(gothambold);


        name.setTypeface(gothamlight);
        username.setTypeface(gothamlight);
        email.setTypeface(gothamlight);
        zipcode.setTypeface(gothamlight);
        password.setTypeface(gothamlight);
        cf_password.setTypeface(gothamlight);

    }

    public void toRegisterPopup(View view) {
        String _name, _username, _email, _zipcode, _password, _cf_password,
                type;
        if (name == null || username == null || email == null || zipcode ==
                null || password == null || cf_password == null) {
            Toast.makeText(Registration.this, "Must fill in all information! " +
                    "", Toast.LENGTH_LONG).show();
        } else if ((password.getText().toString().equals(cf_password.getText
                ().toString()) == false)) {
            Toast.makeText(Registration.this, "Passwords are not matched! ",
                    Toast.LENGTH_LONG).show();
        } else if (!(zipcode.length() == 5)) {
            Toast.makeText(Registration.this, "Invalid Zip Code ", Toast
                    .LENGTH_LONG).show();
        } else if ((email.getText().toString().contains("@") == false) ||
                (email.getText().toString().contains(".") == false)) {
            Toast.makeText(Registration.this, "Invalid Email", Toast
                    .LENGTH_LONG).show();
        } else {
            _name = name.getText().toString();
            _username = username.getText().toString();
            _email = email.getText().toString();
            _zipcode = zipcode.getText().toString();
            _password = password.getText().toString();
            type = "register";


            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, _username, _name, _password,
                    _email, _zipcode);


        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


}
