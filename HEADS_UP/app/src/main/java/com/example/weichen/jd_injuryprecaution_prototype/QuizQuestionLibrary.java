package com.example.weichen.jd_injuryprecaution_prototype;

/**
 * Created by Matthew on 9/29/2017.
 */

public class QuizQuestionLibrary {

    private String mQuestions [] = {
            "Quiz question 1",
            "Quiz question 2",
            "Quiz question 3",
            "Quiz question 4"
    };


    private String mChoices [][] = {
            {"Yes", "Maybe", "No"},
            {"Yes", "Maybe", "No"},
            {"Yes", "Maybe", "No"},
            {"Yes", "Maybe", "No"}
    };


    private String mCorrectAnswers[] = {"Roots", "Leaves", "Flower", "Stem"};




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

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
