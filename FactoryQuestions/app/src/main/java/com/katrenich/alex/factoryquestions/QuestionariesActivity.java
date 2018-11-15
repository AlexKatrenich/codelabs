package com.katrenich.alex.factoryquestions;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class QuestionariesActivity extends BaseActivity implements View.OnClickListener{
    private final String TAG = "QuestionariesActivity_";
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
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });

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
