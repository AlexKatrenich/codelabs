package com.katrenich.alex.factoryquestions.entity.answers;

/*Об'єкт моделі, що відображає відповідь користувача в довільному форматі (текстовий, цілочислельний, дробовий)*/
public class CustomUserAnswer extends Answer {
    private String userAnswer;


    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }


}
