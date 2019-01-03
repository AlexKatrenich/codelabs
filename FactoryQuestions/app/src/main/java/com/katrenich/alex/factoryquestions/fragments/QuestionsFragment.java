package com.katrenich.alex.factoryquestions.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.adapters.QuestionsRecycleListAdapter;

public class QuestionsFragment extends Fragment {
    private final String TAG = "QuestionsFragment_";
    private RecyclerView questionRecView;
    private QuestionsRecycleListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_questions, null);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
    }

    private void init(View view) {
        /*initialize RecyclerView*/
        questionRecView = view.findViewById(R.id.rv_questions_list);
        questionRecView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        /*initialize and add Adapter to RecyclerView*/
        mAdapter = new QuestionsRecycleListAdapter();
        questionRecView.setAdapter(mAdapter);
    }


    @Override
    public void onDestroy() {
        questionRecView.setLayoutManager(null);
        questionRecView.setAdapter(null);
        super.onDestroy();
    }
}
