package com.katrenich.alex.factoryquestions.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.fragments.QuestionsFragment;

public class QuestionsActivity extends BaseActivity {
    private final String TAG = "QuestionsActivity_";
    private Toolbar mToolbar;
    private Fragment qListFragment,
            qSingleChoiseFragment,
            qMultipleChoiseFragment,
            qStringAnswerFragment,
            qDoubleAnswerFragment,
            qIntAnswerFragment;
    private FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        // Ініціалізація полів екрану та змінних
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        /*Ініціалізація верхнього меню*/
        mToolbar = findViewById(R.id.toolbar_questions_list);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        getSupportActionBar().setTitle(
                getResources().getString(
                        R.string.questions_list_activity_title));

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onBackPressed();
                Log.d(TAG, "init: mToolbar -> onBackPressed()");
            }
        });

        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frm_question_list_fragment, new QuestionsFragment()).commit();
        }



    }

    @Override
    protected void onDestroy() {
        mToolbar.setNavigationOnClickListener(null);
        super.onDestroy();
    }
}
