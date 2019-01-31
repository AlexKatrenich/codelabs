package com.katrenich.alex.factoryquestions.entity.questions;

import com.katrenich.alex.factoryquestions.entity.answers.Answer;

public class StringFieldQuestion extends Question {
    private Answer userAnswer;

    public Answer getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(Answer userAnswer) {
        this.userAnswer = userAnswer;
    }
}
