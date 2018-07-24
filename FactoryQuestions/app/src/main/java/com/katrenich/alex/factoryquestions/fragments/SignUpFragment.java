package com.katrenich.alex.factoryquestions.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.*;
import com.katrenich.alex.factoryquestions.adapters.GroupSpinnerAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class SignUpFragment extends Fragment implements View.OnClickListener{

    private final String TAG = "SignUpFragment";

    //константа для валідації емейла
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    // константа для валідації пароля

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9-_\\.]{1,20}$";

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
    private Button btnRegistration;

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
        btnRegistration = v.findViewById(R.id.btn_reg);
        Log.d(TAG, "init: etFullName, etEmail, etPassword, etPassConfirm, btnRegistration");

        // ініціалізація випадаючого списка
        spinGroupList = v.findViewById(R.id.group_list_spinner);
        Log.d(TAG, "init: v.findViewById(R.id.group_list_spinner)");

        // створюється адаптер та заповнюється даними для випадаючого списку
        GroupSpinnerAdapter<String> spinnerAdapter = new GroupSpinnerAdapter<>(v.getContext(),
                R.layout.test_spinner_item, spinnerTestData);


        // задається вигляд списку в режимі відкритого вікна
        spinnerAdapter.setDropDownViewResource(R.layout.group_spinner_dropdown_item);
        spinGroupList.setAdapter(spinnerAdapter);
        spinGroupList.setSelection(0); // задаємо позицію списку для відображення по замовчуванню
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_reg){
            String userEmail = etEmail.getText().toString();
            String userPassword = etPassword.getText().toString();
            String userFullName = etFullName.getText().toString();
            int groupNumber = spinGroupList.getSelectedItemPosition();
            validateFields(userEmail, userPassword, userFullName, groupNumber);
        }
    }

    private boolean validateFields(String userEmail, String userPassword, String userFullName, int groupNumber) {
        boolean valid = true;

        // перевіряємо емейл на валідність
        if (!Pattern.compile(EMAIL_PATTERN).matcher(userEmail).matches()){
            valid = false;
            etEmail.setError(null);
            Log.d(TAG, "validateFields: Email is not valid");
        }

        // перевіряємо пароль на валідність
        if (!Pattern.compile(PASSWORD_PATTERN).matcher(userPassword).matches()){
            valid = false;
            etPassword.setError(null);
            Log.d(TAG, "validateFields: Password is not valid");
        }

        // перевіряємо пароль та підтвердження на збіг
        if (!userPassword.equals(etPassConfirm.getText().toString())){
            valid = false;
            etPassConfirm.setError(null);
            Log.d(TAG, "validateFields: Password not equals password confirm");
        }

        // перевіряємо чи обрана група
        if (groupNumber == 0){
            valid = false;
            Activity activity = this.getActivity();
            if(activity != null){
                Toast.makeText(activity, "Choose your group", Toast.LENGTH_LONG).show();
            }

            Log.d(TAG, "validateFields: Group not was chosen");
        }


        return valid;
    }
}
