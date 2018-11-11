package com.katrenich.alex.factoryquestions;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class QuestionariesActivity extends BaseActivity implements View.OnClickListener{

    private Toolbar mToolbar;


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
        getSupportActionBar().setTitle("Choose questionary");
        mToolbar.setNavigationOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // обработка клика на кнопку бек(на тулбаре)
            case android.R.id.home :
                onBackPressed();
                break;

            default:
                break;
        }
    }


}
