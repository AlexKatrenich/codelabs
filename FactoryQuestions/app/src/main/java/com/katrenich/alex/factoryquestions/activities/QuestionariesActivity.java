package com.katrenich.alex.factoryquestions.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.adapters.QuestionariesListAdapter;
import com.katrenich.alex.factoryquestions.testMethodsMock.QuestionariesActivityMock;

import java.util.List;

public class QuestionariesActivity extends BaseActivity {
    private final String TAG = "QuestionariesActivity_";
    private Toolbar mToolbar;
    private ListView questionariesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaries);

        init();
    }


    // метод для инициализации обектов Активити
    private void init(){
        // инициализация тулбара
        mToolbar = findViewById(R.id.toolbar_questions_list);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(
                getResources().getString(
                        R.string.questionaries_activity_title)); /*Задаю назву екрану зі списком опитувальників*/
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onBackPressed();
                Log.d(TAG, "init: mToolbar -> onBackPressed()");
            }
        });

        questionariesList = findViewById(R.id.lv_questionaries);

        /*Використовується ArrayAdapter для listView*/
        ListAdapter questionariesListAdapter = new QuestionariesListAdapter(this, getQuestionariesList());
        Log.d(TAG, "init: ArrayAdapter");

        questionariesList.setAdapter(questionariesListAdapter);
        Log.d(TAG, "init: questionariesList.setAdapter(questionariesListAdapter)");

        /**/
        questionariesList.setOnItemClickListener((AdapterView.OnItemClickListener) questionariesListAdapter);
    }

    /*Метод для отримання списку з назвами опитувальників*/
    @Nullable
    private List<String> getQuestionariesList() {
        List<String> list;

        /*Заповнення списку тестовими даними, заглушка на back-end*/
        list = new QuestionariesActivityMock().getQuestionariesList();
        Log.d(TAG, "getQuestionariesList: QuestionariesActivityMock().getQuestionariesList()");
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigateUp(){
        Toast.makeText(this, "click back", Toast.LENGTH_SHORT).show();
        finish();
        return true;
    }


    @Override
    protected void onDestroy() {
        /*Обнуляю посилання на об'єкти*/
        setSupportActionBar(null);
        mToolbar.setNavigationOnClickListener(null);
        questionariesList.setAdapter(null);
        questionariesList.setOnItemClickListener(null);
        super.onDestroy();
    }
}
