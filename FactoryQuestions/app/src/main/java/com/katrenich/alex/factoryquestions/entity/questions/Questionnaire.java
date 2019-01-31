package com.katrenich.alex.factoryquestions.entity.questions;

import java.util.List;

/* Клас, що відображає модель "Опитувальник". Кожна група користувачів має свій перелік опитувальників*/
public class Questionnaire {
    private int questionnaireId; /*Ідентифікатор моделі в БД*/
    private List<Question> qList; /*Список питань(Question) в опитувальнику*/
    private List<String> emailList; /*Список е-мейлів для розсилки(при завершенні опитувальника користувачем,
                                       потрібно відправляти результат за вказаним списком емейлів)*/
    private String mCaption; /*Назва опитувальника*/

    public Questionnaire() {

    }

    public Questionnaire(int questionnaireId, String mCaption, List<Question> qList, List<String> emailList) {
        this.questionnaireId = questionnaireId;
        this.qList = qList;
        this.emailList = emailList;
        this.mCaption = mCaption;
    }


    /*Getters and Setters for fields*/
    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public List<Question> getqList() {
        return qList;
    }

    public void setqList(List<Question> qList) {
        this.qList = qList;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String mCaption) {
        this.mCaption = mCaption;
    }
}
