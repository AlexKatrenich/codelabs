package com.katrenich.alex.factoryquestions.entity.answers;

import android.graphics.Bitmap;
import android.icu.util.Calendar;

public class UserAnswer {
    private int AnswerID; /*ІД елементу в таблиці з відповідями користувачів */
    private Calendar answerDate; /*Час надання відповіді в опитувальнику користувачем */
    private Bitmap answerPhoto; /*фото, що додається до відповіді */
    private String answerValue; /*Відповідь користувача */

}
