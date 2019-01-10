package com.katrenich.alex.factoryquestions.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.entity.answers.AnswerOption;

import org.w3c.dom.Text;

import java.util.List;

public class AnswersListAdapter extends BaseAdapter {
    private final String TAG = "AnswersAdapter_";
    private Context mContext; /*контекст, передається при ініціалізації адаптера*/
    private LayoutInflater mLayoutInflater;
    private List<AnswerOption> aList; /*список з перліком варіантів відповідей для питання Question*/

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
            view = mLayoutInflater.inflate(R.layout.item_multi_answer_list, parent, false);
            Log.d(TAG, "getView: View was inflated");
        }

        ((TextView) view.findViewById(R.id.tv_answer_option_number)).setText(String.valueOf(position + 1));
        ((TextView) view.findViewById(R.id.tv_answer_option_text)).setText(aList.get(position).getAnswerText());


        return view;
    }
}
