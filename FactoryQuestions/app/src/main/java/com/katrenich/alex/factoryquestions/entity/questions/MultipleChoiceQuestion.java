package com.katrenich.alex.factoryquestions.entity.questions;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.katrenich.alex.factoryquestions.entity.answers.AnswerOption;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<AnswerOption> answersList = new ArrayList<>();
    private List<AnswerOption> userAnswers = new ArrayList<>();

    public List<AnswerOption> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<AnswerOption> answersList) {
        this.answersList = answersList;
    }

    public void addUserAnswer(AnswerOption answer){
        userAnswers.add(answer);
    }

    public void removeUserAnswer(AnswerOption answerOption){
        userAnswers.remove(answerOption);
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
