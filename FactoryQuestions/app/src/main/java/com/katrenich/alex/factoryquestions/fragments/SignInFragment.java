package com.katrenich.alex.factoryquestions.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.*;

import java.util.regex.Pattern;


public class SignInFragment extends Fragment implements View.OnClickListener{

    private final String TAG = "SignInFragment_";

    //константа для валідації емейла
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //змінні для ініціалізації вкладених елементів фрагмента
    private TextInputEditText etEmail, etPassword;
    private Button signButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.signin_fragment, null);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        init(v);
    }

    //ініціалізація елементів фрагмента
    private void init(View v) {
        etEmail = v.findViewById(R.id.tiet_email_sign_in_data);
        etPassword = v.findViewById(R.id.tiet_pas_sign_in_data);
        signButton = v.findViewById(R.id.btn_sign_in);
        signButton.setOnClickListener(this);
        Log.d(TAG, "init: initialize all view elements");
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_sign_in){

            BaseActivity activity = (BaseActivity) getActivity();
            if(activity != null){
                // відкриваю елемент відображення прогрессу та ховаю клавіатуру
                activity.showProgressDialog();
                Log.d(TAG, "onClick: baseActivity.showProgressDialog()");
                activity.hideKeyboard(v);
            }

            String userEmail = etEmail.getText().toString();
            Log.d(TAG, "onClick: get user email to Variable");
            String userPassword = etPassword.getText().toString();
            Log.d(TAG, "onClick: get user password to Variable");

            if (validateEmail(userEmail) && checkUserAuth(userEmail, userPassword)){
                // Тут робимо перехід на екран зі списком опитувальників
                Intent intent = new Intent(v.getContext(), QuestionariesActivity.class);
                Log.d(TAG, "onClick: new Intent(v.getContext(), QuestionariesActivity.class)");
                startActivity(intent);
                // Знищуємо поточний фрагмент, щоб до нього не повертатись
                //onDestroy();
            } else {
                Toast.makeText(v.getContext(), "Login or password was incorrect", Toast.LENGTH_LONG).show();
            }

            // закриваю елемент відображення прогрессу
            if (activity != null){
                activity.hideProgressDialog();
            }

        }
    }


    // метод для перевірки логіна та пароля по базі даних для авторизації користувача
    private boolean checkUserAuth(String userEmail, String userPassword) {
        // Тут потрібно зробити перевірку співпадіння логіну та паролю по базі даних

        return true;
    }


    // метод перевірки Емейл на валідність
    private boolean validateEmail(String userEmail) {
        boolean b = Pattern.compile(EMAIL_PATTERN).matcher(userEmail).matches();
        Log.d(TAG, "validateEmail: " + b);
        return b;
    }

}
