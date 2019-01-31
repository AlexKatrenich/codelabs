package com.katrenich.alex.factoryquestions.entity.answers;

import android.graphics.Bitmap;
import android.icu.util.Calendar;

/* Об'єкт моделі, що відображає відповідь, яку обрав користувач на відповідь в питанні зі списком відповідей*/
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
