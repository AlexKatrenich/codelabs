package com.katrenich.alex.factoryquestions.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.adapters.QuestionsRecycleListAdapter;

public class QuestionsActivity extends BaseActivity {
    private final String TAG = "QuestionsActivity_";
    private Toolbar mToolbar;
    private RecyclerView mRecycleView;
    private QuestionsRecycleListAdapter qAdapter;


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

        /*Ініціалізація recyclerView*/
        mRecycleView = findViewById(R.id.rv_questions_list);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        /*Ініціалізація та встановлення адаптера в recyclerview*/
        qAdapter = new QuestionsRecycleListAdapter();
        mRecycleView.setAdapter(qAdapter);
    }

    @Override
    protected void onDestroy() {
        mToolbar.setNavigationOnClickListener(null);
        mRecycleView.setLayoutManager(null);
        super.onDestroy();
    }
}
