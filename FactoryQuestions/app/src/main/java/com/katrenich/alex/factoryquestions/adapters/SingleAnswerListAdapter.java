package com.katrenich.alex.factoryquestions.adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.katrenich.alex.factoryquestions.R;
import com.katrenich.alex.factoryquestions.entity.answers.AnswerOption;

import java.util.List;

/* Адаптер для відображення списку варіантів відповідей для питання, з можливістю обрання лише однієї відповіді */
public class SingleAnswerListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{
    public static final String TAG = "SingleAnswerAdapter_";
    private Context mContext; /*контекст, передається при ініціалізації адаптера*/
    private LayoutInflater mLayoutInflater;
    private List<AnswerOption> aList; /*список з перліком варіантів відповідей для питання Question*/

    public SingleAnswerListAdapter(Context mContext, List<AnswerOption> aList){
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


    int selectedPosition = 0; /* позиція пункту списку, що обрана(при першому створенні списку це 0-ва позиція)*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null){
            view = mLayoutInflater.inflate(R.layout.item_single_answer_list, parent, false);
            Log.d(TAG, "getView: View was inflated");
        }

        AnswerOption mAnswer = aList.get(position);

        ((TextView) view.findViewById(R.id.tv_single_answer_option_number))
                .setText(String.valueOf(mAnswer.getAnswerSequenceNumber()));

        ((TextView) view.findViewById(R.id.tv_single_answer_option_text))
                .setText(mAnswer.getAnswerText());

        RadioButton rb = view.findViewById(R.id.rb_answer_is_checked);

        rb.setChecked(selectedPosition == position);
        rb.setTag(position);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = (Integer) v.getTag();
                notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((RadioButton)view.findViewById(R.id.rb_answer_is_checked)).callOnClick(); /*викликаємо метод зміни стану чекбоксу*/

        Log.d(TAG, "onItemClick: CliCK");
    }
}
