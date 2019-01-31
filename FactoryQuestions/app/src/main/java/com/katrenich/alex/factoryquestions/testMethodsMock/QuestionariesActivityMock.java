package com.katrenich.alex.factoryquestions.testMethodsMock;

import com.katrenich.alex.factoryquestions.entity.questions.Question;
import com.katrenich.alex.factoryquestions.entity.questions.Questionnaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionariesActivityMock {

    public List<Questionnaire> getQuestionariesList(){
        List<Questionnaire> list = new ArrayList<>(20);
        list.add(new Questionnaire(15,
                "Human resourses department",
                getQuestionsList(),
                Arrays.asList("alex.katrenich@gmail.com", "a.katrenich@exis.com.ua")));
        list.add(new Questionnaire(16,
                "Accounting department",
                getQuestionsList(),
                Arrays.asList("alex.katrenich@gmail.com", "a.katrenich@exis.com.ua")));
        list.add(new Questionnaire(17,
                "Supply department",
                getQuestionsList(),
                Arrays.asList("alex.katrenich@gmail.com", "a.katrenich@exis.com.ua")));
        list.add(new Questionnaire(18,
                "Quality control department",
                getQuestionsList(),
                Arrays.asList("alex.katrenich@gmail.com", "a.katrenich@exis.com.ua")));
        list.add(new Questionnaire(19,
                "Technological department",
                getQuestionsList(),
                Arrays.asList("alex.katrenich@gmail.com", "a.katrenich@exis.com.ua")));
        list.add(new Questionnaire(20,
                "Department of construction",
                getQuestionsList(),
                Arrays.asList("alex.katrenich@gmail.com", "a.katrenich@exis.com.ua")));
        list.add(new Questionnaire(21,
                "Planning department",
                getQuestionsList(),
                Arrays.asList("alex.katrenich@gmail.com", "a.katrenich@exis.com.ua")));
        list.add(new Questionnaire(22,
                "Department of Risk Analysis",
                getQuestionsList(),
                Arrays.asList("alex.katrenich@gmail.com", "a.katrenich@exis.com.ua")));
        list.add(new Questionnaire(23,
                "Central department",
                getQuestionsList(),
                Arrays.asList("alex.katrenich@gmail.com", "a.katrenich@exis.com.ua")));
        return list;
    }

    public List<Question> getQuestionsList(){
        return null;
    }
}
