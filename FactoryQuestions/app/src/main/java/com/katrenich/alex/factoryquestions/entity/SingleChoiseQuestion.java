package com.katrenich.alex.factoryquestions.entity;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class SingleChoiseQuestion extends Question {
    private List<AnswerOption> answersList = new ArrayList<>();
    private AnswerOption checkedAnswer;


    public AnswerOption getCheckedAnswer() {
        return checkedAnswer;
    }

    public void setCheckedAnswer(AnswerOption checkedAnswer) {
        this.checkedAnswer = checkedAnswer;
    }

    public List<AnswerOption> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<AnswerOption> answersList) {
        this.answersList = answersList;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
