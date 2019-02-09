package com.katrenich.alex.factoryquestions.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
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
import com.katrenich.alex.factoryquestions.entity.questions.Questionnaire;
import com.katrenich.alex.factoryquestions.testMethodsMock.QuestionariesActivityMock;

import java.util.List;

public class QuestionnairesActivity extends BaseActivity {
    private final String TAG = "QuestionariesActivity_";
    private Toolbar mToolbar;
    private ListView questionariesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaries);

        init();
    }


    // метод для ініціалізації об'єктів Активності
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
        ListAdapter listAdapter = new QuestionariesListAdapter(this, getQuestionnairesList());
        Log.d(TAG, "init: ArrayAdapter");

        questionariesList.setAdapter(listAdapter);
        Log.d(TAG, "init: questionariesList.setAdapter(listAdapter)");

        /*Задаємо слухач для обробки кліку по елементу списку*/
        questionariesList.setOnItemClickListener((AdapterView.OnItemClickListener) listAdapter);
    }

    /*Метод для отримання списку з назвами опитувальників*/
    @Nullable
    private List<Questionnaire> getQuestionnairesList() {
        List<Questionnaire> list;

        /*Заповнення списку тестовими даними, заглушка на back-end*/
        list = new QuestionariesActivityMock().getQuestionariesList();
        Log.d(TAG, "getQuestionnariesList: QuestionariesActivityMock().getQuestionnairesList()");
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigateUp(){
        Toast.makeText(this, "click back", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onNavigateUp: click on back arrow");
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
