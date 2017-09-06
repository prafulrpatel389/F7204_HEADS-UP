package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity {
    private EditText name;
    private EditText username;
    private EditText email;
    private EditText zipcode;
    private EditText password;
    private EditText cf_password;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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

        password = (EditText)findViewById(R.id.registration_input_password);
        if (password.getText().toString().length() == 0) {
            password.setError("Password can't be empty!");
        }
        cf_password = (EditText) findViewById(R.id.registration_input_passwordConfirm);
        if (cf_password.getText().toString().length() == 0) {
            cf_password.setError("Password can't be empty!");
        }

        register = (Button)findViewById(R.id.registration_button_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder rBuilder = new AlertDialog.Builder(Registration.this);
                View mView = getLayoutInflater().inflate(R.layout.registration_popup, null);
                final TextView registerPop = (TextView) mView.findViewById(R.id.textView5);
                registerPop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Registration.this, Login.class));
                    }
                });
                rBuilder.setView(mView);
                AlertDialog dialog = rBuilder.create();
                dialog.show();
            }
        });


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }




}
