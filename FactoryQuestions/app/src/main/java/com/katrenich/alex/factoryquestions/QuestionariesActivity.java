package com.katrenich.alex.factoryquestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.adapters.QuestionariesListAdapter;
import com.katrenich.alex.factoryquestions.testMethodsMock.QuestionariesActivityMock;

import java.util.ArrayList;
import java.util.List;

public class QuestionariesActivity extends BaseActivity implements View.OnClickListener{
    private final String TAG = "QuestionariesActivity_";
    private Toolbar mToolbar;
    private ListView questionariesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaries);

        initialize();
    }


    // метод для инициализации обектов Активити
    private void initialize(){
        // инициализация тулбара
        mToolbar = findViewById(R.id.toolbar);
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
                Log.d(TAG, "initialize: mToolbar -> onBackPressed()");
            }
        });

        questionariesList = findViewById(R.id.lv_questionaries);

        /*Використовується ArrayAdapter для listView*/
//        ArrayAdapter<String> questionariesListAdapter = new ArrayAdapter<String>(this, R.layout.group_list_view_item, getQuestionariesList());
        ListAdapter questionariesListAdapter = new QuestionariesListAdapter(this, getQuestionariesList());
        Log.d(TAG, "initialize: ArrayAdapter");

        questionariesList.setAdapter(questionariesListAdapter);
        Log.d(TAG, "initialize: questionariesList.setAdapter(questionariesListAdapter)");
    }

    /*Метод для отримання списку з назвами опитувальників*/
    @Nullable
    private List<String> getQuestionariesList() {
        List<String> list;

        /*Заповнення списку тестовими даними, заглушка на back-end*/
        list = new QuestionariesActivityMock().getQuestionariesTitle();
        Log.d(TAG, "getQuestionariesList: QuestionariesActivityMock().getQuestionariesTitle()");
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
    public void onClick(View v) {

    }


}
