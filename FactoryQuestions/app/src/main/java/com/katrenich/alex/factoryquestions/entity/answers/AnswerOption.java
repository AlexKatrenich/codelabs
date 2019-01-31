package com.katrenich.alex.factoryquestions.entity.answers;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

/* Клас створений для відображення об'єкту моделі, що відповідає за варіанти відповідей для відображення в запитаннях
 * зі списком відповідей*/
public class AnswerOption {
    private int answerOptionID; /*ІД в таблиці відповідей БД*/
    private String answerText; /*текст відповіді*/
    private int answerSequenceNumber; /*Порядковий номер в списку відповідей*/
    private int answerValue; /*Числове значення важливості відповіді*/

    public AnswerOption() {}

    public AnswerOption(int answerOptionID,
                        String answerText,
                        int answerSequenceNumber,
                        int answerValue) {
        this.answerOptionID = answerOptionID;
        this.answerText = answerText;
        this.answerSequenceNumber = answerSequenceNumber;
        this.answerValue = answerValue;
    }

    public AnswerOption(String answerText, int answerSequenceNumber) {
        this.answerText = answerText;
        this.answerSequenceNumber = answerSequenceNumber;
    }

    public int getAnswerOptionID() {
        return answerOptionID;
    }

    public void setAnswerOptionID(int answerOptionID) {
        this.answerOptionID = answerOptionID;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getAnswerSequenceNumber() {
        return answerSequenceNumber;
    }

    public void setAnswerSequenceNumber(int answerSequenceNumber) {
        this.answerSequenceNumber = answerSequenceNumber;
    }

    public int getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(int answerValue) {
        this.answerValue = answerValue;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(answerOptionID, answerText, answerSequenceNumber, answerValue);
    }

    @Override
    public String toString() {
        return "AnswerOption{" +
                "answerOptionID=" + answerOptionID +
                ", answerText='" + answerText + '\'' +
                ", answerSequenceNumber=" + answerSequenceNumber +
                ", answerValue=" + answerValue +
                '}';
    }
}
