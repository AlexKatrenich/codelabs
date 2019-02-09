package com.katrenich.alex.factoryquestions.entity.managers;

import android.content.Context;

import com.katrenich.alex.factoryquestions.entity.users.User;

/*Клас singleton для управління авторизацією користувача, та перевіркою авторизації при переході між активностями*/
public class UserAuthManager {
    private static UserAuthManager userAuthManager;
    private boolean isUserAuthored = false;
    private User user;


    private UserAuthManager(Context context){

    }

    public static UserAuthManager getUserAuthManager(Context context){
        if(userAuthManager == null){
            userAuthManager = new UserAuthManager(context);
        }

        return userAuthManager;
    }

    public boolean isUserAuthored() {
        return isUserAuthored;
    }

    public void setUserAuthored(boolean userAuthored) {
        isUserAuthored = userAuthored;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // метод для перевірки логіна та пароля по базі даних для авторизації користувача
    public boolean checkUserAuth(String userEmail, String userPassword) {
        // Тут потрібно зробити перевірку співпадіння логіну та паролю по базі даних

        return true;
    }
}
