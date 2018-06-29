package com.katrenich.alex.factoryquestions.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.katrenich.alex.factoryquestions.*;


public class SignInFragment extends Fragment {

    //Тестові дані, потрібно замінити на дані, що підтягуватимуться з серверної БД
    String[] spinnerTestData = {"Група 1", "Група 2", "Група 3", "Група 4", "Група 5", "Група 6"};

    //змінні для ініціалізації вкладених елементів фрагмента
    private TextInputEditText etEmail, etPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.signin_fragment, null);
    }

    @Override
    public void onStart() {
        super.onStart();

        etEmail = getActivity().findViewById(R.id.tiet_email_sign_in_data);
        etPassword = getActivity().findViewById(R.id.tiet_pas_sign_in_data);

    }
}
