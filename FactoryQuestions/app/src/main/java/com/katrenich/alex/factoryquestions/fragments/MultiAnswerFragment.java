package com.katrenich.alex.factoryquestions.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.entity.questions.Question;


/* Абстрактний клас в який винесено типові операції по ініціалізації елементів UI для фрагментів
 * зі списком варіантів відповідей для користувача */
public abstract class MultiAnswerFragment extends Fragment implements View.OnClickListener{

    private final String TAG = "MultiAnswerFragment_";
    private TextView tvNumbQuestion, tvTextQuestion;
    private Button btnPrev, btnNext;
    private ListView lvAnswers;
    protected Question mQuestion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_multi_answers, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*зчитування питання зі списку питань*/
        mQuestion = readQuestion();

        /*Інціалізація полів UI*/
        tvNumbQuestion = view.findViewById(R.id.tv_multi_answer_number_fragment);
        tvNumbQuestion.setText(String.valueOf(mQuestion.getSequenceNumber()));

        tvTextQuestion = view.findViewById(R.id.tv_multi_answer_text_fragment);
        tvTextQuestion.setText(mQuestion.getQuestionText());

        btnNext = view.findViewById(R.id.btn_next_multi_answer_fragment);
        btnNext.setOnClickListener(this);
        Log.d(TAG, "init: btnNext.setOnClickListener");
        btnPrev = view.findViewById(R.id.btn_prev_multi_answer_fragment);
        btnPrev.setOnClickListener(this);
        Log.d(TAG, "init: btnPrev.setOnClickListener");

        lvAnswers = view.findViewById(R.id.lv_answers_multi_question_fragment);

        setAdapter(view, lvAnswers);
    }

    /*Абстрактний метод для конкретного екземпляра фрагменту, створення його адаптеру та заповнення даними*/
    protected abstract void setAdapter(View view, ListView lvAnswers);

    /*Абстрактний метод для зчитування питання та подальшого його відображення в конкретному фрагменті*/
    protected abstract Question readQuestion();

    @Override
    public void onDestroy() {
        /*Очистка пам'яті*/
        btnPrev.setOnClickListener(null);
        btnNext.setOnClickListener(null);
        lvAnswers.setAdapter(null);
        Log.d(TAG, "onDestroy: Memory clear");
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next_multi_answer_fragment:
                Toast.makeText(v.getContext(), "ButtonNext clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_prev_multi_answer_fragment:
                Toast.makeText(v.getContext(), "ButtonPrev clicked", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;


        }
    }

}
