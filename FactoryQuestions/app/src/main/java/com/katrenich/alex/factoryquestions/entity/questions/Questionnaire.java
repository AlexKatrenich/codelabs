package com.katrenich.alex.factoryquestions.entity.questions;

import java.util.List;

public class Questionnaire {
    private int questionnaireId;
    private List<Question> qList;
    private int questionOrder;
    private List<String> emailList;

    public Questionnaire() {

    }

    public Questionnaire(int questionnaireId, List<Question> qList, int questionOrder, List<String> emailList) {
        this.questionnaireId = questionnaireId;
        this.qList = qList;
        this.questionOrder = questionOrder;
        this.emailList = emailList;
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

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int questionOrder) {
        this.questionOrder = questionOrder;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }
}
