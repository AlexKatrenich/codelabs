package com.katrenich.alex.factoryquestions.entity.questions;

import com.katrenich.alex.factoryquestions.entity.answers.UserAnswerType;

/* Клас для відображення об'єкту моделі, що характеризує питання(question) з однією відповіддю користувача,
 * відповідь в довільному форматі(користувач вводить вручну з клавіатури)*/
public class StringFieldQuestion extends Question {
    private UserAnswerType answerType; /*Тип відповіді, в якому потрібно відповісти користувачеві(текст, цифра і т.п.)*/

    public StringFieldQuestion(UserAnswerType answerType) {
        this.answerType = answerType;
    }

    public StringFieldQuestion(int sequenceNumber, int answerPower, String questionText, UserAnswerType answerType) {
        super(sequenceNumber, answerPower, questionText);
        this.answerType = answerType;
    }

    public StringFieldQuestion(String questionText, int questionId, UserAnswerType answerType) {
        super(questionText, questionId);
        this.answerType = answerType;
    }

    public StringFieldQuestion(int questionId, String questionText, int answerPower, UserAnswerType answerType) {
        super(questionId, questionText, answerPower);
        this.answerType = answerType;
    }

    public UserAnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(UserAnswerType answerType) {
        this.answerType = answerType;
    }
}
