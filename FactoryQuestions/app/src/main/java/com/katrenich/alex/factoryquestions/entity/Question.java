package com.katrenich.alex.factoryquestions.entity;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class Question {
    private int questionId;
    private String questionText;
    private int answerPower;
    private int answerType;
    private QuestionType questionType;


    public Question() {

    }

    public Question(int questionId,
                    String questionText,
                    int answerPower,
                    int answerType,
                    QuestionType questionType) {

        this.questionId = questionId;
        this.questionText = questionText;
        this.answerPower = answerPower;
        this.answerType = answerType;
        this.questionType = questionType;
    }

    /*Getters and Setters for fields*/
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getAnswerPower() {
        return answerPower;
    }

    public void setAnswerPower(int answerPower) {
        this.answerPower = answerPower;
    }

    public int getAnswerType() {
        return answerType;
    }

    public void setAnswerType(int answerType) {
        this.answerType = answerType;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return questionId == question.questionId &&
                answerPower == question.answerPower &&
                answerType == question.answerType &&
                Objects.equals(questionText, question.questionText) &&
                questionType == question.questionType;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(questionId, questionText, answerPower, answerType, questionType);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", answerPower=" + answerPower +
                ", answerType=" + answerType +
                ", questionType=" + questionType +
                '}';
    }
}
