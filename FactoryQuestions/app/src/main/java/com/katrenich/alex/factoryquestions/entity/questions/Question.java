package com.katrenich.alex.factoryquestions.entity.questions;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class Question {
    private int questionId; /*ІД питання в таблиці БД*/
    private String questionText; /*Текст запитання*/
    private int answerPower; /*Числове значення що виражає значимість питання в опитувальнику*/
    private int sequenceNumber; /*Порядковий номер питання в опитувальнику*/


    public Question() {}

    public Question(int sequenceNumber, int answerPower, String questionText){
        this.sequenceNumber =  sequenceNumber;
        this.answerPower = answerPower;
        this.questionText = questionText;
    }

    public Question(String questionText, int questionId){
        this.questionText = questionText;
        this.questionId = questionId;
    }

    public Question(int questionId,
                    String questionText,
                    int answerPower) {

        this.questionId = questionId;
        this.questionText = questionText;
        this.answerPower = answerPower;
    }

    /*Getters and Setters for fields*/
    public int getQuestionId() {
        return questionId;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return questionId == question.questionId &&
                answerPower == question.answerPower &&
                Objects.equals(questionText, question.questionText);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(questionId, questionText, answerPower);
    }

    @Override
    public String toString() {
        return "Question { " +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", sequenceNumber=" + sequenceNumber +
                '}';
    }
}
