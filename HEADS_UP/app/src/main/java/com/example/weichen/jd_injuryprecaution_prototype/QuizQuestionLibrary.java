package com.example.weichen.jd_injuryprecaution_prototype;

/**
 * Created by Matthew on 9/29/2017.
 */

public class QuizQuestionLibrary {

    private String mQuestions [] = {
            "A concussion is a...\n\n" +
                "A. type of traumatic brain injury (TBI)\n" +
                "B. a brain bruise\n" +
                "C. loud siren heard far away.",
            "When can concussions occur?\n\n" +
                "A. only during contact sports\n" +
                "B. only when an individual loses consciousness\n" +
                "C. in any activity regardless of whether someone loses consciousness",
            "How do you identify a concussion?\n\n" +
                "A. by looking at CT or MRI scans of the brain\n" +
                "B. by watching for difference signs and symptoms\n" +
                "C. by asking if the athlete had their \"bell rung\" in the last hit",
    };


    private String mChoices [][] = {
            {"A", "B", "C"},
            {"A", "B", "C"},
            {"A", "B", "C"}
    };


    private String mCorrectAnswers[] = {"A", "C", "B"};


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
