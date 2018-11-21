package com.katrenich.alex.factoryquestions.testMethodsMock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.adapters.QuestionariesListAdapter;

import java.util.List;

public class TestActivity extends AppCompatActivity {
    private final String TAG = "TestActivity_";
    ListView listView;
    private List<String> questionariesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        listView = findViewById(R.id.test_list_view);
        questionariesList = getQuestionariesList();
        ListAdapter questionariesListAdapter = new QuestionariesListAdapter(this, questionariesList);

        // Set adapter
        listView.setAdapter(questionariesListAdapter);

    }


    public List<String> getQuestionariesList() {
        List<String> list;

        /*Заповнення списку тестовими даними, заглушка на back-end*/
        list = new QuestionariesActivityMock().getQuestionariesTitle();
        Log.d(TAG, "getQuestionariesList: QuestionariesActivityMock().getQuestionariesTitle()");
        return list;
    }
}
