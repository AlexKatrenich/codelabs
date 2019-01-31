package com.katrenich.alex.factoryquestions.adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.entity.questions.Questionnaire;

import java.util.List;


public class QuestionariesListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{
    private static final String TAG = "QuestionariesAdapter_";
    private Context mContext;
    LayoutInflater mLInflater;
    List<Questionnaire> mList;

    public QuestionariesListAdapter(Context context, List<Questionnaire> list) {
        mContext = context;
        mList = list;
        mLInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Log.d(TAG, mList.toString());
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

        if(view == null){
            view = mLInflater.inflate(R.layout.item_group_list_view, parent, false);
            Log.d(TAG, "getView: mLInflater.inflate -> new View");
        }

        // заповнюємо View з отриманого списку mList
        ((TextView)view.findViewById(R.id.tv_questionnaire_number)).setText(String.valueOf(position));

        ((TextView)view.findViewById(R.id.tv_questionnaire_title)).setText(mList.get(position).getCaption());
        return view;
    }


    /*В адаптері реалізовано обробку itemClick на View*/
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String mTitle = mList.get(position).getCaption();
        Toast.makeText(mContext, "Click on title: " + mTitle, Toast.LENGTH_LONG).show();
    }

}
