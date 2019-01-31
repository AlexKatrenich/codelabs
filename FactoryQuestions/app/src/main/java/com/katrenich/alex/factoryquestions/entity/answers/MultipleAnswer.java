package com.katrenich.alex.factoryquestions.entity.answers;

import android.graphics.Bitmap;
import android.icu.util.Calendar;

import java.util.ArrayList;
import java.util.List;

/* Об'єкт моделі, що відображає список відповідей, які обрав користувач для відповіді на запитання*/
public class MultipleAnswer extends Answer {
    private List<AnswerOption> answers = new ArrayList<>(); /*список з відповідями, що обрав користувач*/

    public MultipleAnswer(){

    }

    public MultipleAnswer(List<AnswerOption> answers) {
        this.answers = answers;
    }

    public MultipleAnswer(int answerID, Calendar answerDate, Bitmap answerPhoto, List<AnswerOption> answers) {
        super(answerID, answerDate, answerPhoto);
        this.answers = answers;
    }


    /*Getters and Setters*/
    public List<AnswerOption> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerOption> answers) {
        this.answers = answers;
    }

    public void addAnswer(AnswerOption answer){
        answers.add(answer);
    }

    public void removeAnswer(AnswerOption answer){
        answers.remove(answer);
    }

    @Override
    public String toString() {
        return "MultipleAnswer{" +
                "answers=" + answers +
                '}';
    }
}
