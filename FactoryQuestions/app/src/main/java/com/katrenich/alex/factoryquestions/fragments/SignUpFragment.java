package com.katrenich.alex.factoryquestions.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9-_\\.]{2,20}$";

    //константа для валідації Логіну користувача
    private static final String USER_FULLNAME_PATTERN = "^[а-яА-ЯёЁa-zA-Z\\.]{2,20}$";


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
    private TextInputLayout tilFullname, tilEmail, tilPassword, tilPassConfirm;
    private Spinner spinGroupList;
    private Button btnRegistration;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }


    @NonNull
    private void init(View v) {
        etFullName = v.findViewById(R.id.tiet_full_name_reg_data);
        etEmail = v.findViewById(R.id.tiet_email_reg_data);
        etPassword = v.findViewById(R.id.tiet_pas_reg_data);
        etPassConfirm = v.findViewById(R.id.tiet_pas_reg_confirm_data);
        btnRegistration = v.findViewById(R.id.btn_reg);
        btnRegistration.setOnClickListener(this);

        tilEmail = v.findViewById(R.id.til_email_reg_holder);
        tilFullname = v.findViewById(R.id.til_full_name_reg_holder);
        tilPassConfirm = v.findViewById(R.id.til_pas_reg_confirm_holder);
        tilPassword = v.findViewById(R.id.til_pas_reg_holder);
        Log.d(TAG, "init: etFullName, etEmail, etPassword, etPassConfirm, btnRegistration");

        // ініціалізація випадаючого списка
        spinGroupList = v.findViewById(R.id.group_list_spinner);
        Log.d(TAG, "init: v.findViewById(R.id.group_list_spinner)");

        // створюється адаптер та заповнюється даними для випадаючого списку
        GroupSpinnerAdapter<String> spinnerAdapter = new GroupSpinnerAdapter<>(v.getContext(),
                R.layout.item_spinner, spinnerTestData);



        // задається вигляд списку в режимі відкритого вікна
        spinnerAdapter.setDropDownViewResource(R.layout.item_group_spinner_dropdown);
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

            Log.d(TAG, "User email :" + userEmail + "\nUser password : " + userPassword
                    + "\nUser password confirm : " + etPassConfirm.getText().toString()
                    + "\nGroup : " + spinnerTestData.get((int) spinGroupList.getSelectedItemId()));

            boolean valFields = validateFields(userEmail, userPassword, userFullName, groupNumber);

            Log.d(TAG, "onClick: validateFields = " + valFields);

            // Для тестування, після налаштування обмінів з сервером - видалити
            Activity activity = this.getActivity();
            if(activity != null && valFields){
                Toast.makeText(activity, "User email :" + userEmail + "\nUser password : " + userPassword
                        + "\nUser password confirm : " + etPassConfirm.getText().toString()
                        + "\nGroup : " + spinnerTestData.get((int) spinGroupList.getSelectedItemId()), Toast.LENGTH_SHORT).show();
            }
        }
    }

    // метод для валідації даних внесених користувачем
    private boolean validateFields(String userEmail, String userPassword, String userFullName, int groupNumber) {
        boolean valid = true;

        // перевіряємо Full Name користувача на валідність
        if (!Pattern.compile(USER_FULLNAME_PATTERN).matcher(userFullName).matches()){
            valid = false;
            tilFullname.setError("Incorrect full name");
            Log.d(TAG, "validateFields: User Full name is not valid");
        }

        // перевіряємо емейл на валідність
        if (!Pattern.compile(EMAIL_PATTERN).matcher(userEmail).matches()){
            valid = false;
            tilEmail.setError("Incorrect email");
            Log.d(TAG, "validateFields: Email is not valid");
        }

        // перевіряємо пароль на валідність
        if (!Pattern.compile(PASSWORD_PATTERN).matcher(userPassword).matches()){
            valid = false;
            tilPassword.setError("Password must contain at least 2 letters or numbers");
            Log.d(TAG, "validateFields: Password is not valid");
        }

        // перевіряємо пароль та підтвердження на збіг
        if (!userPassword.equals(etPassConfirm.getText().toString())){
            valid = false;
            tilPassConfirm.setError("Password and confirm password must be same");
            Log.d(TAG, "validateFields: Password not equals password confirm");
        }

        // перевіряємо чи обрана група
        if (groupNumber == 0){
            valid = false;

            //TODO в прописати видачу помилки в ТексВ'ю Спінера.

            Activity activity = this.getActivity();
            if(activity != null){
                Toast.makeText(activity, "Please choose your group", Toast.LENGTH_LONG).show();
            }

            Log.d(TAG, "validateFields: Group not was chosen");
        }

        return valid;
    }
}
