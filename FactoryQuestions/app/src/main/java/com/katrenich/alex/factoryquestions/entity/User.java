package com.katrenich.alex.factoryquestions.entity;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class User {
    private String fullName;
    private int userId;
    private String hash;
    private String email;
    private String password;

    public User() {

    }

    public User(String fullName, String email) {
        this.fullName = fullName;
        this.userId = userId;
        this.email = email;
    }

    public User(String fullName, int userId, String hash, String email, String password) {
        this.fullName = fullName;
        this.userId = userId;
        this.hash = hash;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(fullName, user.fullName) &&
                Objects.equals(hash, user.hash);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(fullName, userId, hash);
    }
}
