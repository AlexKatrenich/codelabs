package com.katrenich.alex.factoryquestions.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.entity.answers.AnswerOption;

import java.util.List;

public class MultiAnswersListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{
    private final String TAG = "AnswersAdapter_";
    private Context mContext; /*контекст, передається при ініціалізації адаптера*/
    private LayoutInflater mLayoutInflater;
    private List<AnswerOption> aList; /*список з перліком варіантів відповідей для питання Question*/


    public MultiAnswersListAdapter(Context mContext, List<AnswerOption> aList) {
        this.mContext = mContext;
        this.aList = aList;
        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        final AnswerOption mAnswer = aList.get(position);

        ((TextView) view.findViewById(R.id.tv_answer_option_number))
                .setText(String.valueOf(mAnswer.getAnswerSequenceNumber()));

        ((TextView) view.findViewById(R.id.tv_answer_option_text))
                .setText(mAnswer.getAnswerText());

        ((CheckBox) view.findViewById(R.id.cb_answer_is_checked)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(mContext, "Answer: " + mAnswer.getAnswerText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((CheckBox)view.findViewById(R.id.cb_answer_is_checked)).toggle(); /*викликаємо метод зміни стану чекбоксу*/

        Log.d(TAG, "onItemClick: CliCK");
    }

}
