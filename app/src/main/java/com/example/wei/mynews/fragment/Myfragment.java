package com.example.wei.mynews.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Wei on 2017/5/18.
 */

public class Myfragment extends Fragment {
    private int mText;
    private TextView mTextView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            mText = getArguments().getInt("NEWSTYPE");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
       mTextView=new TextView(getActivity());
        ViewGroup.LayoutParams params= new ViewGroup.LayoutParams(-1,-1);
        mTextView.setLayoutParams(params);
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setTextColor(Color.RED);
        mTextView.setText(mText);
        return mTextView;
    }
}
