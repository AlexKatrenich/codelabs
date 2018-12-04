package com.katrenich.alex.factoryquestions.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.entity.Question;
import com.katrenich.alex.factoryquestions.testMethodsMock.QuestionsActivityMock;

import java.util.ArrayList;
import java.util.List;

public class QuestionsRecycleListAdapter extends RecyclerView.Adapter<QuestionsRecycleListAdapter.QuestionsViewHolder> {
    private List<Question> qList;

    public QuestionsRecycleListAdapter(){
        setItems();
    }

    /*Метод для заповнення списку запитань*/
    public void setItems(){
        qList = new QuestionsActivityMock().getSimpleQuestionsList();
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_recycler_view_item, parent, false);
        return new QuestionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {
        holder.bind(qList.get(position));
    }

    @Override
    public int getItemCount() {
        return qList.size();
    }



    /* Вбудований клас для імплементації View-компонент
     * Використовується для кешування View-компонентів та швидкого доступу до них */
    class QuestionsViewHolder extends RecyclerView.ViewHolder{
        private TextView qNumber;
        private TextView qCaption;

        public QuestionsViewHolder(View itemView) {
            super(itemView);
            qNumber = itemView.findViewById(R.id.tv_question_number);
            qCaption = itemView.findViewById(R.id.tv_question_caption);
        }

        public void bind(Question question){
            qNumber.setText(String.valueOf(question.getQuestionId()));
            qCaption.setText(question.getQuestionText());
        }
    }

}
