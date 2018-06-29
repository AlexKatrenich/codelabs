package com.katrenich.alex.factoryquestions;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.katrenich.alex.factoryquestions.adapters.LoginRecyclerAdapter;
import com.katrenich.alex.factoryquestions.fragments.LoginFragment;
import com.katrenich.alex.factoryquestions.fragments.SigninFragment;


public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        // ініціалізація Toolbar
        toolbar = findViewById(R.id.login_activity_toolbar);
        setSupportActionBar(toolbar);

        // ініціалізація TabLayout та додавання двох вкладок
//        tabs = findViewById(R.id.tabs);
//        tabs.addTab(tabs.newTab().setText("Tab 1"));
//        tabs.addTab(tabs.newTab().setText("Tab 2"));

        ViewPager viewPager = findViewById(R.id.login_viewpager);
        setupViewPager(viewPager);

        // ініціалізація TabLayout та підписання його на отримання даних з ViewPager
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        LoginRecyclerAdapter adapter = new LoginRecyclerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(), "LOGIN");
        adapter.addFragment(new SigninFragment(), "SIGN-IN");
        viewPager.setAdapter(adapter);
    }


}
