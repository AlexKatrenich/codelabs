package com.katrenich.alex.factoryquestions.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.*;
import com.katrenich.alex.factoryquestions.adapters.GroupSpinnerAdapter;

import java.util.Arrays;
import java.util.List;


public class SignUpFragment extends Fragment {

    //Тестові дані, потрібно замінити на дані, що підтягуватимуться з серверної БД
    List<String> spinnerTestData = Arrays.asList(
                            "Chose group",
                            "Group 1",
                            "Group 2",
                            "Group 3",
                            "Group 4",
                            "Group 5",
                            "Group 6");

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

        // ініціалізація випадаючого списка
        spinGroupList = v.findViewById(R.id.group_list_spinner);

        // створюється адаптер та заповнюється даними для випадаючого списку
        GroupSpinnerAdapter<String> spinnerAdapter = new GroupSpinnerAdapter<>(v.getContext(),
                R.layout.test_spinner_item, spinnerTestData);

//        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(v.getContext(),
//                android.R.layout.simple_spinner_item, spinnerTestData);


        // задається вигляд списку в режимі відкритого вікна
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinGroupList.setAdapter(spinnerAdapter);
        spinGroupList.setSelection(0); // задаємо позицію списку для відображення по замовчуванню
    }

}
