package com.example.assignapp2019s1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class introduction extends AppCompatActivity {

    private List<Rule> rulesList = new ArrayList<>();
    // these are the rules for the game
    private static String strule1 = "Rule1: Each round of the game lasts for 30 seconds";
    private static String strule2 = "Rule2: Once you see a hamster jumping out, hit it and get one score";
    private static String strule3 = "Rule3: If you missed 4 hamsters the game will end";
    private static String strule4 = "Rule4: Hamsters will appear faster as less time left";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduction);
        // this method will initialize the rulelist
        initRules();
        RuleAdapter adapter = new RuleAdapter(introduction.this,R.layout.rule_item,rulesList);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }

    private void initRules() {
        Rule rule1 = new Rule(strule1, R.drawable.rule);
        rulesList.add(rule1);
        Rule rule2 = new Rule(strule2, R.drawable.images);
        rulesList.add(rule2);
        Rule rule3 = new Rule(strule3, R.drawable.rule);
        rulesList.add(rule3);
        Rule rule4 = new Rule(strule4, R.drawable.images);
        rulesList.add(rule4);
    }
}
