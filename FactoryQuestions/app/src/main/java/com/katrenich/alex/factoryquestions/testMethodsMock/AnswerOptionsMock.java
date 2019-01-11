package com.katrenich.alex.factoryquestions.testMethodsMock;


import com.katrenich.alex.factoryquestions.entity.answers.AnswerOption;

import java.util.ArrayList;
import java.util.List;

public class AnswerOptionsMock {
    List mList = new ArrayList(4);

    public List getAnswerOptionsList(){
        mList.add(new AnswerOption("Answer 1 - wtf", 1));
        mList.add(new AnswerOption("Answer 2 - yes", 2));
        mList.add(new AnswerOption("Answer 3 - no", 3));
        mList.add(new AnswerOption("Answer 4 - stfu", 4));
        return mList;
    }
}
