package com.katrenich.alex.factoryquestions.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.katrenich.alex.factoryquestions.R;

public class QuestionsActivity extends BaseActivity {
    private final String TAG = "QuestionsActivity_";
    Toolbar mToolbar;


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


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
