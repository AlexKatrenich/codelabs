package com.katrenich.alex.factoryquestions.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.adapters.AnswersListAdapter;
import com.katrenich.alex.factoryquestions.entity.questions.MultipleChoiseQuestion;
import com.katrenich.alex.factoryquestions.entity.questions.Question;
import com.katrenich.alex.factoryquestions.testMethodsMock.AnswerOptionsMock;
import com.katrenich.alex.factoryquestions.testMethodsMock.QuestionsActivityMock;

public class MultiAnswerFragment extends Fragment implements View.OnClickListener {
    private final String TAG = "MultiAnswerFragment_";
    private TextView tvNumbQuestion, tvTextQuestion;
    private Button btnPrev, btnNext;
    private ListView lvAnswers;
    private Question mQuestion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_multi_answer, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        /*Читаємо питання для відображення на екрані*/
        readQuestion();

        tvNumbQuestion = view.findViewById(R.id.tv_multi_question_number_fragment);
        tvNumbQuestion.setText(String.valueOf(mQuestion.getSequenceNumber()));

        tvTextQuestion = view.findViewById(R.id.tv_multi_question_text_fragment);
        tvTextQuestion.setText(mQuestion.getQuestionText());

        btnNext = view.findViewById(R.id.btn_next_multi_question_fragment);
        btnNext.setOnClickListener(this);
        Log.d(TAG, "init: btnNext.setOnClickListener");
        btnPrev = view.findViewById(R.id.btn_prev_multi_question_fragment);
        btnPrev.setOnClickListener(this);
        Log.d(TAG, "init: btnPrev.setOnClickListener");

        lvAnswers = view.findViewById(R.id.lv_answers_multi_question_fragment);
        /*Адаптер для відображення списку питань*/
        ListAdapter answersAdapter = new AnswersListAdapter(view.getContext(), ((MultipleChoiseQuestion)mQuestion).getAnswersList());
        Log.d(TAG, "init: ListAdapter created");
        lvAnswers.setAdapter(answersAdapter);

        lvAnswers.setOnItemClickListener((AdapterView.OnItemClickListener)answersAdapter);
        Log.d(TAG, "init: set Click listener on list items");
    }


    public boolean readQuestion(){
        mQuestion = new QuestionsActivityMock().getMultipleChoiseQuestion();
        Log.d(TAG, "readQuestion: mQuestion created");
        return true;
    }

    @Override
    public void onDestroy() {
        /*Clean memory*/
        btnPrev.setOnClickListener(null);
        btnNext.setOnClickListener(null);
        lvAnswers.setOnItemClickListener(null);
        lvAnswers.setAdapter(null);
        Log.d(TAG, "onDestroy: Memory clear");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next_multi_question_fragment:
                Toast.makeText(v.getContext(), "ButtonNext clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_prev_multi_question_fragment:
                Toast.makeText(v.getContext(), "ButtonPrev clicked", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;


        }
    }
}

