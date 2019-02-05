package com.katrenich.alex.factoryquestions.entity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;

import com.katrenich.alex.factoryquestions.entity.questions.Question;

/* Клас Singleton для збереження списку запитань та передачі даних між фрагментами*/
public class QuestionsListManager {
    private static QuestionsListManager sQuestionsListManager;
    private ArrayMap<Integer,Question> sQuestions;

    private QuestionsListManager(Context context){

    }

    public static QuestionsListManager getQuestionsList(Context context){
        if (sQuestionsListManager == null){
            sQuestionsListManager = new QuestionsListManager(context);
        }

        return sQuestionsListManager;
    }

    public void setQuestions(ArrayMap<Integer,Question> questions){
        sQuestions = questions;
    }

    @Nullable
    public ArrayMap<Integer,Question> getQuestions(){
        return sQuestions;
    }

    @Nullable
    public Question getQuestionById(int id){
        if(sQuestions != null && sQuestions.containsKey(id)){
            return sQuestions.get(id);
        }
        return null;
    }

    public boolean setQuestion(Question question){
        if (sQuestions!=null){
            sQuestions.put(question.getQuestionId(), question);
        }

        return false;
    }

}
