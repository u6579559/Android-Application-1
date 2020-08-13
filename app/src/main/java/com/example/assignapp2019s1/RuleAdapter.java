//bulid a new Arrayadapter for the rule_item in the listView

package com.example.assignapp2019s1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RuleAdapter extends ArrayAdapter<Rule> {

    private int resourceId;

    public RuleAdapter(Context context, int textViewResourceID, List<Rule> lists) {
        super(context, textViewResourceID,lists);
        resourceId = textViewResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Rule rule = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView ruleImage = (ImageView) view.findViewById(R.id.rule_image);
        TextView textView = (TextView) view.findViewById(R.id.rule_name);
        ruleImage.setImageResource(rule.getImageID());
        textView.setText(rule.getName());
        return view;
    }
}
