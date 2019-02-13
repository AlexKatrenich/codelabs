package com.katrenich.alex.factoryquestions.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.ArrayMap;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.adapters.QuestionariesListAdapter;
import com.katrenich.alex.factoryquestions.entity.managers.QuestionnairesManager;
import com.katrenich.alex.factoryquestions.entity.questions.Questionnaire;
import com.katrenich.alex.factoryquestions.testMethodsMock.QuestionariesActivityMock;

import java.util.ArrayList;
import java.util.List;

public class QuestionnairesActivity extends BaseActivity {
    private final String TAG = "QuestionariesActivity_";
    private Toolbar mToolbar;
    private ListView questionnairesList;
    private List<Questionnaire> list;


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

        questionnairesList = findViewById(R.id.lv_questionaries);

        /*Використовується ArrayAdapter для listView*/
        ListAdapter listAdapter;
        if(getQuestionnairesList()){
            listAdapter = new QuestionariesListAdapter(this, list);
            Log.d(TAG, "init: ArrayAdapter with full list of questions");
        } else {
            listAdapter = new QuestionariesListAdapter(this, new ArrayList<Questionnaire>());
            Log.d(TAG, "init: ArrayAdapter with empty list of questions" );
        }

        questionnairesList.setAdapter(listAdapter);
        Log.d(TAG, "init: questionnairesList.setAdapter(listAdapter)");

        /*Задаємо слухач для обробки кліку по елементу списку*/
        questionnairesList.setOnItemClickListener((AdapterView.OnItemClickListener) listAdapter);
    }

    /*Метод для отримання списку з назвами опитувальників*/
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private boolean getQuestionnairesList() {
        QuestionnairesManager questionnairesManager =  QuestionnairesManager.getQuestionnairesManager(this);
        ArrayMap<Integer, Questionnaire> qList = questionnairesManager.getListQuestionaires();
        /* Якщо мапа отримана із сінглтона:
         * - пуста, заповнюємо список з БД
         * - заповнена, використовуємо її список*/
        if (qList != null){
            list = (ArrayList) qList.values();
            return true;
        } else {
            showProgressDialog();
            /*Заповнення списку тестовими даними, заглушка на back-end*/
            list = new QuestionariesActivityMock().getQuestionariesList();
            qList = new ArrayMap<>();
            for (Questionnaire q : list) {
                qList.put(q.getQuestionnaireId(), q);
            }
            questionnairesManager.setListQuestionaires(qList);
            hideProgressDialog();
            return true;
        }
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
        questionnairesList.setAdapter(null);
        questionnairesList.setOnItemClickListener(null);
        super.onDestroy();
    }
}
