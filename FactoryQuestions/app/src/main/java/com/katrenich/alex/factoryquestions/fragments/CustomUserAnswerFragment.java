package com.katrenich.alex.factoryquestions.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.entity.answers.CustomUserAnswer;
import com.katrenich.alex.factoryquestions.entity.answers.UserAnswerType;
import com.katrenich.alex.factoryquestions.entity.questions.StringFieldQuestion;
import com.katrenich.alex.factoryquestions.testMethodsMock.QuestionsActivityMock;

/* Клас(фрагмент) для відображення питання з полем для вводу відповіді користувача, відповідь може бути
 * числова
 * текстова */

public class CustomUserAnswerFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "CustomUserAnswer_";
    private TextView tvQuestionNumber, tvQuestionText;
    private TextInputEditText uAnswer;
    private Button btnNext, btnPrev;
    private StringFieldQuestion mQuestion;
    private CustomUserAnswer mAnswer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_user_answer, null);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mQuestion = readQuestion();

        /* Ініціалізація елементів UI*/
        tvQuestionNumber = view.findViewById(R.id.tv_numb_question_custom_question_fragment);
        tvQuestionNumber.setText(String.valueOf(mQuestion.getSequenceNumber()));
        Log.d(TAG, "onViewCreated: ");
        tvQuestionText = view.findViewById(R.id.tv_question_text);
        tvQuestionText.setText(mQuestion.getQuestionText());

        btnNext = view.findViewById(R.id.btn_next_question_fragment);
        btnNext.setOnClickListener(this);

        btnPrev = view.findViewById(R.id.btn_prev_question_fragment);
        btnPrev.setOnClickListener(this);

        uAnswer = view.findViewById(R.id.tiet_answer_field);

    }

    /* метод для зчитування питання(Question) яке потрібно відобразити на UI*/
    private StringFieldQuestion readQuestion() {
        return (new QuestionsActivityMock()).getQuestionCustomAnswer(UserAnswerType.STRINGANSWER);
    }

    @Override
    public void onDestroy() {
        btnPrev.setOnClickListener(null);
        btnNext.setOnClickListener(null);
        super.onDestroy();
    }

    private void setUserAnswer(CustomUserAnswer userAnswer){
        mAnswer = userAnswer;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next_question_fragment :
                Toast.makeText(v.getContext(), "Button next was clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_prev_question_fragment :
                Toast.makeText(v.getContext(), "Button Prev was clicked", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
}
