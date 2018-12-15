package com.katrenich.alex.factoryquestions.entity.answers;

import android.graphics.Bitmap;
import android.icu.util.Calendar;

public class SingleAnswer extends Answer {
    private AnswerOption userAnswer;

    public SingleAnswer(){

    }

    public SingleAnswer(AnswerOption userAnswer) {
        this.userAnswer = userAnswer;
    }

    public SingleAnswer(int answerID, Calendar answerDate, Bitmap answerPhoto, AnswerOption userAnswer) {
        super(answerID, answerDate, answerPhoto);
        this.userAnswer = userAnswer;
    }

    public SingleAnswer(int answerID, Calendar answerDate, Bitmap answerPhoto, String value, AnswerOption userAnswer) {
        super(answerID, answerDate, answerPhoto, value);
        this.userAnswer = userAnswer;
    }

    /*Getters and Setters*/

    public AnswerOption getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(AnswerOption userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {
        return "SingleAnswer{" +
                "userAnswer=" + userAnswer +
                '}';
    }
}
