package com.example.timur.finaltestproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainFragment extends Fragment implements TextWatcher, View.OnClickListener {
    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;
    private String mTextForTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mTextView = view.findViewById(R.id.text_View);
        mEditText = view.findViewById(R.id.edit_Text);
        mButton = view.findViewById(R.id.btn);
        mEditText.addTextChangedListener(this);
        mButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("message", mTextForTv);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString("message"));
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.length() > 0) {
            mTextForTv = mEditText.getText().toString();
            mTextView.setText(mTextForTv);
        } else mTextView.setText("");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("activity");
        String text = mTextView.getText().toString();
        intent.putExtra("text", text);
        startActivity(intent);
    }
}
