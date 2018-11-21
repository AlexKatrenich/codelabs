package com.katrenich.alex.factoryquestions.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.katrenich.alex.factoryquestions.R;

import java.util.List;

/**/
public class QuestionariesListAdapter extends BaseAdapter {
    private Context mContext;
    LayoutInflater mLInflater;
    List mList;

    public QuestionariesListAdapter(Context context, List list) {
        mContext = context;
        mList = list;
        mLInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кількість елементів
    @Override
    public int getCount() {
        return mList.size();
    }

    // елемент по позиції
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    // id по позиції
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view != null){
            mLInflater.inflate(R.layout.group_list_view_item, parent, false);
        }

        // заповнюємо View з отриманого списку mList
        ((TextView)view.findViewById(R.id.tv_questionnaire_number)).setText(position);
        ((TextView)view.findViewById(R.id.tv_questionnaire_title)).setText((String)mList.get(position));

        return view;
    }
}
