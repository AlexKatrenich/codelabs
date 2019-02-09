package com.katrenich.alex.factoryquestions.entity.managers;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.katrenich.alex.factoryquestions.entity.questions.Question;

/* Клас Singleton для збереження списку запитань та передачі даних між фрагментами*/
public class QuestionsListManager {
    private static final String TAG = "QuestionsListManager_";
    private static QuestionsListManager sQuestionsListManager;
    private ArrayMap<Integer,Question> sQuestions;

    private QuestionsListManager(Context context){

    }

    public static QuestionsListManager getQuestionsList(Context context){
        if (sQuestionsListManager == null){
            sQuestionsListManager = new QuestionsListManager(context);
            Log.d(TAG, "getQuestionsList: sQuestionsListManager created");
        }

        return sQuestionsListManager;
    }

    public void setQuestions(ArrayMap<Integer,Question> questions){
        sQuestions = questions;
        Log.d(TAG, "setQuestions: list of questions added to ArrayMap");
    }

    @Nullable
    public ArrayMap<Integer,Question> getQuestions(){
        return sQuestions;
    }

    @Nullable
    public Question getQuestionById(int id){
        if(sQuestions != null && sQuestions.containsKey(id)){
            Log.d(TAG, "getQuestionById: ID = " + id);
            return sQuestions.get(id);
        }
        return null;
    }

    public boolean setQuestion(Question question){
        if (sQuestions!=null){
            sQuestions.put(question.getQuestionId(), question);
            Log.d(TAG, "setQuestion: true");
            return true;
        }

        Log.d(TAG, "setQuestion: false");
        return false;
    }

}
