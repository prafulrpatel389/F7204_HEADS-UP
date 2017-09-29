package com.example.weichen.jd_injuryprecaution_prototype;

/**
 * Created by Soyeon on 9/17/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Surveys extends AppCompatActivity {

    private SurveyQuestionLibrary mSurveyQuestionLibrary = new SurveyQuestionLibrary();

    private TextView mQuestionView;

    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonQuit;

    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveys);

        mQuestionView = (TextView)findViewById(R.id.question);

        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);

        mButtonQuit    = (Button)findViewById(R.id.quit);

        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            //My logic for Button goes in here
            updateQuestion();
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            //My logic for Button goes in here
            updateQuestion();
            }
        });

        //End of Button Listener for Button2

        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            //My logic for Button goes in here
            updateQuestion();
            }
        });

        //End of Button Listener for Button3

        //Start of Button Listener for Quit
        mButtonQuit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            //My logic for Button goes in here

            Intent i = new Intent(Surveys.this, Activities.class);
            i.putExtra("frgToLoad", 2);

            // Now start your activity
            startActivity(i);
            }
        });

        //End of Button Listener for Quit
    }

    private void updateQuestion(){
        if (mQuestionNumber > 3) {
            Intent i = new Intent(Surveys.this, Activities.class);
            i.putExtra("frgToLoad", 2);

            // Now start your activity
            startActivity(i);
        } else {
            mQuestionView.setText(mSurveyQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mSurveyQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mSurveyQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mSurveyQuestionLibrary.getChoice3(mQuestionNumber));

            mQuestionNumber++;
        }
    }

}
