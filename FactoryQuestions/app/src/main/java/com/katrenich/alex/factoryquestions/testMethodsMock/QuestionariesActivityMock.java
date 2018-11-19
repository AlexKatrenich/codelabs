package com.katrenich.alex.factoryquestions.testMethodsMock;

import java.util.ArrayList;
import java.util.List;

public class QuestionariesActivityMock {
    public List<String> getQuestionariesTitle(){
        List<String> list = new ArrayList<>(20);
        list.add("Human resourses department");
        list.add("Accounting department");
        list.add("Supply department");
        list.add("Quality control department");
        list.add("Technological department");
        list.add("Department of construction");
        list.add("Planning department");
        list.add("Department of Risk Analysis");
        list.add("Central department");
        return list;
    }
}
