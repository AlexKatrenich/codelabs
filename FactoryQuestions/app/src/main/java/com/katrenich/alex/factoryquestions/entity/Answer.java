package com.katrenich.alex.factoryquestions.entity;

import android.graphics.Bitmap;

import java.util.Date;

public class Answer {
    private int answerId;
    private Questionnaire mQuestionnaire;
    private Question mQuestion;
    private Date mDate;
    private int AnswerValue;
    private Bitmap photoAnswer;

    public Answer() {

    }

    public Answer(int answerId,
                  Questionnaire mQuestionnaire,
                  Question mQuestion,
                  Date mDate,
                  int answerValue,
                  Bitmap photoAnswer) {

        this.answerId = answerId;
        this.mQuestionnaire = mQuestionnaire;
        this.mQuestion = mQuestion;
        this.mDate = mDate;
        AnswerValue = answerValue;
        this.photoAnswer = photoAnswer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Questionnaire getmQuestionnaire() {
        return mQuestionnaire;
    }

    public void setmQuestionnaire(Questionnaire mQuestionnaire) {
        this.mQuestionnaire = mQuestionnaire;
    }

    public Question getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(Question mQuestion) {
        this.mQuestion = mQuestion;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public int getAnswerValue() {
        return AnswerValue;
    }

    public void setAnswerValue(int answerValue) {
        AnswerValue = answerValue;
    }

    public Bitmap getPhotoAnswer() {
        return photoAnswer;
    }

    public void setPhotoAnswer(Bitmap photoAnswer) {
        this.photoAnswer = photoAnswer;
    }
}
