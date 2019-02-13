package com.katrenich.alex.factoryquestions.entity.managers;

import android.content.Context;
import android.util.ArrayMap;

import com.katrenich.alex.factoryquestions.entity.questions.Questionnaire;

/* Клас Singleton для управління опитувальниками */
public class QuestionnairesManager {
    private static QuestionnairesManager manager;
    private ArrayMap<Integer, Questionnaire> listQuestionaires;


    private QuestionnairesManager(Context context){}

    public static QuestionnairesManager getQuestionnairesManager(Context context){
        if(manager == null){
            manager = new QuestionnairesManager(context);
        }

        return manager;
    }

    public ArrayMap<Integer, Questionnaire> getListQuestionaires() {
        return listQuestionaires;
    }

    public void setListQuestionaires(ArrayMap<Integer, Questionnaire> listQuestionaires) {
        this.listQuestionaires = listQuestionaires;
    }
}
