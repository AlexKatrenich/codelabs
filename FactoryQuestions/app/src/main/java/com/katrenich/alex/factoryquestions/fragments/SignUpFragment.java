package com.katrenich.alex.factoryquestions.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.katrenich.alex.factoryquestions.*;


public class SignUpFragment extends Fragment {

    //Тестові дані, потрібно замінити на дані, що підтягуватимуться з серверної БД
    String[] spinnerTestData = {"Група 1", "Група 2", "Група 3", "Група 4", "Група 5", "Група 6"};

    // Змінні для ініціалізації полів фрагменту
    private TextInputEditText etFullName, etEmail, etPassword, etPassConfirm;
    private Spinner spinGroupList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.signup_fragment, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }


    private void init(View v) {
        etFullName = v.findViewById(R.id.tiet_full_name_reg_data);
        etEmail = v.findViewById(R.id.tiet_email_reg_data);
        etPassword = v.findViewById(R.id.tiet_pas_reg_data);
        etPassConfirm = v.findViewById(R.id.tiet_pas_reg_confirm_data);
        
    }

}
