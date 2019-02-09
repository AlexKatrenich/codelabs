package com.katrenich.alex.factoryquestions.entity.managers;

import android.content.Context;

import com.katrenich.alex.factoryquestions.entity.questions.Questionnaire;

/* Клас Singleton для управління опитувальниками */
public class QuestionnairesManager {
    private static QuestionnairesManager manager;
    private Questionnaire mQuestionnaire;


    private QuestionnairesManager(Context context){}

    public static QuestionnairesManager getQuestionnairesManager(Context context){
        if(manager == null){
            manager = new QuestionnairesManager(context);
        }

        return manager;
    }

    public Questionnaire getQuestionnaire() {
        return mQuestionnaire;
    }

    public void setQuestionnaire(Questionnaire mQuestionnaire) {
        this.mQuestionnaire = mQuestionnaire;
    }

}
