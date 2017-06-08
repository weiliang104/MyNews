package com.example.wei.mynews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wei.mynews.R;


/**
 * Created by Wei on 2017/5/26.
 */
public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);
        tv= (TextView) itemView.findViewById(R.id.tv);
    }
}
