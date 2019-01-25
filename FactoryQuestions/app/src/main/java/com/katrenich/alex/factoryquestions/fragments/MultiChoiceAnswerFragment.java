package com.katrenich.alex.factoryquestions.fragments;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.katrenich.alex.factoryquestions.adapters.MultiAnswersListAdapter;
import com.katrenich.alex.factoryquestions.entity.questions.MultipleChoiceQuestion;
import com.katrenich.alex.factoryquestions.testMethodsMock.QuestionsActivityMock;

public class MultiChoiceAnswerFragment extends MultiAnswerFragment {
    private final String TAG = "MultiAnswerFragment_";
    private ListView lvAnswers;
    private MultipleChoiceQuestion mQuestion;


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
        mQuestion = new QuestionsActivityMock().getMultipleChoiseQuestion();
        super.mQuestion = mQuestion;
    }


    @Override
    public void onDestroy() {
        lvAnswers.setOnItemClickListener(null);
        super.onDestroy();
    }
}

