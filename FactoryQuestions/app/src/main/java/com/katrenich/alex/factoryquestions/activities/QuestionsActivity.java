package com.katrenich.alex.factoryquestions.activities;


import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.katrenich.alex.factoryquestions.R;

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
        init();
    }

    private void init() {
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

        qListFragment = new Fragment();
        fTrans = getFragmentManager().beginTransaction();
        fTrans.add(R.id.frm_question_list_fragment, qListFragment);
        fTrans.commit();

        qSingleChoiseFragment = new Fragment();
        qMultipleChoiseFragment = new Fragment();
        qStringAnswerFragment = new Fragment();
        qDoubleAnswerFragment = new Fragment();
        qIntAnswerFragment = new Fragment();
    }

    @Override
    protected void onDestroy() {
        mToolbar.setNavigationOnClickListener(null);
        super.onDestroy();
    }
}
