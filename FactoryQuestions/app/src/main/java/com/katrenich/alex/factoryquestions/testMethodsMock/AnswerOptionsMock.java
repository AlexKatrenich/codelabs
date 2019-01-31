package com.katrenich.alex.factoryquestions.testMethodsMock;


import com.katrenich.alex.factoryquestions.entity.answers.AnswerOption;

import java.util.ArrayList;
import java.util.List;

public class AnswerOptionsMock {
    List mList = new ArrayList(4);

    public List getAnswerOptionsList(){
        mList.add(new AnswerOption(321, "Answer 1 - wtf", 1, 1));
        mList.add(new AnswerOption(345,"Answer 2 - yes", 2, 1));
        mList.add(new AnswerOption(354,"Answer 3 - no", 3, 1));
        mList.add(new AnswerOption(245,"Answer 4 - stfu", 4, 1));
        return mList;
    }
}
