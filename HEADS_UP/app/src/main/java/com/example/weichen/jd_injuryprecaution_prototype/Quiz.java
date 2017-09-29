package com.example.weichen.jd_injuryprecaution_prototype;

/**
 * Created by Matthew on 9/29/2017.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {

    private QuizQuestionLibrary mQuizQuestionLibrary = new QuizQuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonQuit;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber;

    private String quizQuestionId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveys);

        mQuestionView = (TextView)findViewById(R.id.question);

        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);

        mButtonQuit    = (Button)findViewById(R.id.quit);
        mButtonQuit.setText("Save & Quit");

        Bundle bundle = getIntent().getExtras();
        int survey_no = bundle.getInt("survey_no");

        quizQuestionId = "quizQuestion" + survey_no;

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

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                }else {
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                }else {
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3

        mButtonQuit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                storeCurrentQuestion(getCurrentQuestion() - 1);

                Intent i = new Intent(Quiz.this, Activities.class);
                i.putExtra("frgToLoad", 1);

                // Now start your activity
                startActivity(i);
            }
        });
    }

    private void updateQuestion(){

        mQuestionNumber = getCurrentQuestion();

        if (mQuestionNumber > 3) {
            Intent i = new Intent(Quiz.this, Activities.class);
            i.putExtra("frgToLoad", 1);

            storeCurrentQuestion(0);

            // Now start your activity
            startActivity(i);
        } else {
            mQuestionView.setText(mQuizQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuizQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuizQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuizQuestionLibrary.getChoice3(mQuestionNumber));

            mQuestionNumber++;

            storeCurrentQuestion(mQuestionNumber);
        }
    }

    private void storeCurrentQuestion(int id) {
        SharedPreferences mSharedPreferences = getSharedPreferences(quizQuestionId, MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("quizquestion", id);
        mEditor.apply();
    }

    private int getCurrentQuestion() {
        SharedPreferences mSharedPreferences = getSharedPreferences(quizQuestionId, MODE_PRIVATE);
        int selectedQuestion = mSharedPreferences.getInt("quizquestion", 0);
        return selectedQuestion;
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}
