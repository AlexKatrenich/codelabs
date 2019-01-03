package com.katrenich.alex.factoryquestions.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.katrenich.alex.factoryquestions.R;

public class MultiAnswerFragment extends Fragment implements View.OnClickListener {
    private final String TAG = "MultiAnswerFragment_";
    private TextView tvNumbQuestion, tvTextQuestion;
    private Button btnPrev, btnNext;
    private ListView lvQuestions;

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
        tvNumbQuestion = view.findViewById(R.id.tv_multi_question_number_fragment);
        tvTextQuestion = view.findViewById(R.id.tv_multi_question_text_fragment);
        btnNext = view.findViewById(R.id.btn_next_multi_question_fragment);
        btnNext.setOnClickListener(this);
        btnPrev = view.findViewById(R.id.btn_prev_multi_question_fragment);
        btnPrev.setOnClickListener(this);
        lvQuestions = view.findViewById(R.id.lv_answers_multi_question_fragment);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next_multi_question_fragment:
                break;

            case R.id.btn_prev_multi_question_fragment:
                break;

            default:
                break;


        }
    }
}

