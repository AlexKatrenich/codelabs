package com.katrenich.alex.factoryquestions;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.katrenich.alex.factoryquestions.adapters.LoginRecyclerAdapter;
import com.katrenich.alex.factoryquestions.fragments.LoginFragment;
import com.katrenich.alex.factoryquestions.fragments.SigninFragment;


public class SignActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        init();
    }

    private void init() {

        // ініціалізація ViewPager - контейнер для відображення фрагментів
        ViewPager viewPager = findViewById(R.id.login_viewpager);
        setupViewPager(viewPager);

        // ініціалізація TabLayout та підписання його на отримання даних з ViewPager
        tabs = findViewById(R.id.tl_login_signin);
        tabs.setupWithViewPager(viewPager);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.cpt_authorization);
        collapsingToolbarLayout.setTitle(getString(R.string.log_collapsing_toolbar_title));
    }

    private void setupViewPager(ViewPager viewPager) {
        LoginRecyclerAdapter adapter = new LoginRecyclerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(), getString(R.string.sign_in_tab_layout_text));
        adapter.addFragment(new SigninFragment(), getString(R.string.sign_up_tab_layout_text));
        viewPager.setAdapter(adapter);
    }


}
