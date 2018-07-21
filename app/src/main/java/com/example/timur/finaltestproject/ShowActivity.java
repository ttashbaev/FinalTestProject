package com.example.timur.finaltestproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    private TextView mTextView;
    private String[] mList;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        mTextView = findViewById(R.id.tv_show);
        mListView = findViewById(R.id.list_view);
        String showText = getIntent().getStringExtra("text");
        mTextView.setText(showText);

        mList = showText.split("(?!^)");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                mList);
        mListView.setAdapter(adapter);
    }

}
