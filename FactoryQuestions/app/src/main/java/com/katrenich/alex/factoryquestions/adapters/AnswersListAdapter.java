package com.katrenich.alex.factoryquestions.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.katrenich.alex.factoryquestions.entity.answers.AnswerOption;

import java.util.List;

public class AnswersListAdapter extends BaseAdapter {
    private final String TAG = "AnswersAdapter_";
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<AnswerOption> aList;

    public AnswersListAdapter(Context mContext, List<AnswerOption> aList) {
        this.mContext = mContext;
        this.aList = aList;
        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Log.d(TAG, aList.toString());
    }

    @Override
    public int getCount() {
        return aList.size();
    }

    @Override
    public Object getItem(int position) {
        return aList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null){
            //TODO
        }

        return null;
    }
}
