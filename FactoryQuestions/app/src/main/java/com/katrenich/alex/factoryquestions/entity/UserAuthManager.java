package com.katrenich.alex.factoryquestions.entity;

import android.content.Context;

/*Клас singleton для управління авторизацією користувача, та перевіркою авторизації при переході між активностями*/
public class UserAuthManager {
    private static UserAuthManager userAuthManager;
    private boolean isUserAuthored = false;


    private UserAuthManager(Context context){

    }

    public static UserAuthManager getUserAuthManager(Context context){
        if(userAuthManager == null){
            userAuthManager = new UserAuthManager(context);
        }

        return userAuthManager;
    }

    public void setIsUserAuthored(boolean isAuthored){
        isUserAuthored = isAuthored;
    }

    public boolean getIsUserAuthored(){
        return isUserAuthored;
    }

}
