package com.katrenich.alex.factoryquestions.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.katrenich.alex.factoryquestions.*;


public class SignInFragment extends Fragment implements View.OnClickListener{

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
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_sign_in){
            //TODO
        }
    }
}
