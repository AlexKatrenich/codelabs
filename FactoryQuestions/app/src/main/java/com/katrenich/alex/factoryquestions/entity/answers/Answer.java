package com.katrenich.alex.factoryquestions.entity.answers;

import android.graphics.Bitmap;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class Answer {

    private int answerID; /*ІД елементу в таблиці з відповідями користувачів */
    private Calendar answerDate; /*Час надання відповіді в опитувальнику користувачем */
    private Bitmap answerPhoto; /*фото, що додається до відповіді */
    private String value; /*текстова відповідь користувача*/

    public Answer() {
    }

    public Answer(int answerID, Calendar answerDate, Bitmap answerPhoto) {
        this.answerID = answerID;
        this.answerDate = answerDate;
        this.answerPhoto = answerPhoto;
    }

    public Answer(int answerID, Calendar answerDate, Bitmap answerPhoto, String value) {
        this.answerID = answerID;
        this.answerDate = answerDate;
        this.answerPhoto = answerPhoto;
        this.value = value;
    }

    /*Getters and Setters*/

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public Calendar getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Calendar answerDate) {
        this.answerDate = answerDate;
    }

    public Bitmap getAnswerPhoto() {
        return answerPhoto;
    }

    public void setAnswerPhoto(Bitmap answerPhoto) {
        this.answerPhoto = answerPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return answerID == answer.answerID;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(answerID, answerDate, answerPhoto, value);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerID=" + answerID +
                ", answerDate=" + answerDate +
                ", value=" + value +
                '}';
    }
}
