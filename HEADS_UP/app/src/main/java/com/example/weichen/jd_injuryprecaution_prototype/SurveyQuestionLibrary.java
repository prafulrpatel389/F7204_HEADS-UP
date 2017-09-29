package com.example.weichen.jd_injuryprecaution_prototype;

/**
 * Created by Preston on 9/29/2017.
 */

public class SurveyQuestionLibrary {

    private String mQuestions [] = {
        "Survey question 1",
        "Survey question 2",
        "Survey question 3",
        "Survey question 4"
    };


    private String mChoices [][] = {
        {"Yes", "Maybe", "No"},
        {"Yes", "Maybe", "No"},
        {"Yes", "Maybe", "No"},
        {"Yes", "Maybe", "No"}
    };

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

}