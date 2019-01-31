package com.katrenich.alex.factoryquestions.testMethodsMock;

import com.katrenich.alex.factoryquestions.entity.answers.UserAnswerType;
import com.katrenich.alex.factoryquestions.entity.questions.MultipleChoiceQuestion;
import com.katrenich.alex.factoryquestions.entity.questions.Question;
import com.katrenich.alex.factoryquestions.entity.questions.StringFieldQuestion;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivityMock {


    private List<Question> qList;

    public List<Question> getSimpleQuestionsList(){
        qList = new ArrayList<>(15);
        qList.add(new Question("Что такое ООП?", qList.size() + 1));
        qList.add(new Question("Бывают ли моменты, когда Вас покидает вдохновение (теряете веру в себя, в свой бизнес)?", qList.size() + 1));
        qList.add(new Question("Опишите свою рабочую обстановку?", qList.size() + 1));
        qList.add(new Question("Вы любите свою работу (бизнес, продукт, услугу, дело)?", qList.size() + 1));
        qList.add(new Question("Чем Вы любите заниматься в свободное время?", qList.size() + 1));
        qList.add(new Question("Какие советы Вы можете дать новичкам (сотрудникам, читателям)?", qList.size() + 1));
        qList.add(new Question("Вы остаетесь самим собой, выполняя свою работу, или это PR ход?", qList.size() + 1));
        qList.add(new Question("Какова доля удачи и везения в Вашем проекте?", qList.size() + 1));
        qList.add(new Question("Есть ли у Вас свой девиз, миссия?", qList.size() + 1));
        qList.add(new Question("Вы уже много добились в своей профессии, изменила ли Вас популярность?", qList.size() + 1));
        qList.add(new Question("Как Вы думаете, почему в обществе (на рынке, в компании, на форумах, в интернете) сформировалась такая точка зрения?", qList.size() + 1));
        qList.add(new Question("Какие могут быть подводные камни в Вашей сфере?", qList.size() + 1));
        qList.add(new Question("Как окружающие воспринимают Ваше развитие (работу, перемены)?", qList.size() + 1));
        qList.add(new Question("Где Вы ищете своих заказчиков (клиентов, покупателей, инвесторов, партнеров)?", qList.size() + 1));
        qList.add(new Question("Нет желания все бросить к «чертовой бабушке» и начать что-то совершенно новое?", qList.size() + 1));
        qList.add(new Question("Сформируйте Ваше отношение к жизни (бизнесу, семье, коллегам, сотрудникам) в пяти словах?", qList.size() + 1));
        return qList;
    }

    public List<Question> getDifferentTypeQuestionList() {
        qList = new ArrayList<>(10);
        qList.add(new MultipleChoiceQuestion());

        return qList;
    }

    public StringFieldQuestion getQuestionCustomAnswer(UserAnswerType type){
        switch (type){
            case INTANSWER:
                return new StringFieldQuestion(12, 1, "How old are you?", UserAnswerType.INTANSWER);
            case DOUBLEANSWER:
                return new StringFieldQuestion(15, 1, "What is the value of Pi?", UserAnswerType.DOUBLEANSWER);
            case STRINGANSWER:
                return new StringFieldQuestion(17, 1, "What are you name?", UserAnswerType.STRINGANSWER);
            default:
                return new StringFieldQuestion(17, 1, "What are you name?", UserAnswerType.STRINGANSWER);
        }
    }

    /*метод повертає заповнений об'єкт питання з багатьма відповідями(AnswerOption)*/
    public MultipleChoiceQuestion getMultipleChoiceQuestion(){
        MultipleChoiceQuestion mQuestion = new MultipleChoiceQuestion();
        mQuestion.setQuestionText("Do you like this App");
        mQuestion.setQuestionId(354);
        mQuestion.setSequenceNumber(4);
        mQuestion.setAnswersList(new AnswerOptionsMock().getAnswerOptionsList());
        return mQuestion;
    }

}
