package com.katrenich.alex.factoryquestions.fragments;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.katrenich.alex.factoryquestions.adapters.MultiAnswersListAdapter;
import com.katrenich.alex.factoryquestions.entity.questions.SingleChoiceQuestion;
import com.katrenich.alex.factoryquestions.testMethodsMock.QuestionsActivityMock;

public class SingleChoiceAnswerFragment extends MultiAnswerFragment {
    private final String TAG = "SingleAnswerFragment_";
    private ListView lvAnswers;
    private SingleChoiceQuestion mQuestion;

    @Override
    protected void setAdapter(View view, ListView answers) {
        lvAnswers = answers;

        /*Адаптер для відображення списку питань*/
        ListAdapter answersAdapter = new MultiAnswersListAdapter(view.getContext(), mQuestion.getAnswersList());
        Log.d(TAG, "init: ListAdapter created");
        lvAnswers.setAdapter(answersAdapter);

        lvAnswers.setOnItemClickListener((AdapterView.OnItemClickListener)answersAdapter);
    }

    @Override
    protected void readQuestion() {
        mQuestion = new QuestionsActivityMock().getSingleChoiseQuestion();
    }
}
