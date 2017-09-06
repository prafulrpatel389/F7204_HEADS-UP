package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forgot extends AppCompatActivity {

    private Button sendLink;
    private EditText username;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        username = (EditText) findViewById(R.id.forgot_username);
        email = (EditText) findViewById(R.id.forgot_email);
        sendLink = (Button) findViewById(R.id.forgot_sendLink);
        sendLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username == null && email == null){
                    Toast.makeText(Forgot.this, "Username or Email can't both be empty!", Toast.LENGTH_LONG).show();
                } else {
                    AlertDialog.Builder rBuilder = new AlertDialog.Builder(Forgot.this);
                    View mView = getLayoutInflater().inflate(R.layout.forgot_popup, null);
                    final TextView forgotPop = (TextView) mView.findViewById(R.id.textView8);
                    forgotPop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(Forgot.this, Login.class));
                        }
                    });
                    rBuilder.setView(mView);
                    AlertDialog dialog = rBuilder.create();
                    dialog.show();
                }




            }
        });

    }
}
