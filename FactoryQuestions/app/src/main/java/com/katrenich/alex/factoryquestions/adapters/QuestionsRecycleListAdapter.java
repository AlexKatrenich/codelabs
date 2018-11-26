package com.katrenich.alex.factoryquestions.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class QuestionsRecycleListAdapter extends RecyclerView.Adapter<QuestionsRecycleListAdapter.QuestionsViewHolder> {

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    /* Вбудований клас для імплементації View-компонент
     * Використовується для кешування View-компонентів та швидкого доступу до них */
    class QuestionsViewHolder extends RecyclerView.ViewHolder{

        public QuestionsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
