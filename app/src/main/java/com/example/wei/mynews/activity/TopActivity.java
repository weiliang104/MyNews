package com.example.wei.mynews.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.wei.mynews.R;
import com.example.wei.mynews.fragment.JokeFragment;
import com.example.wei.mynews.fragment.MyFragment;
import com.example.wei.mynews.fragment.NewFragment;
import com.example.wei.mynews.fragment.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends AppCompatActivity {
    private ViewPager pager;
private List<Fragment> topList=new ArrayList<>();
    private Topadapter mtopadapter;
    private TextView news;
    private TextView joke;
    private TextView weather;
    private TextView my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        initTopList();
        mtopadapter=new Topadapter(getSupportFragmentManager(),topList);
        pager.setAdapter(mtopadapter);
        pager.setOffscreenPageLimit(4);
        initview();
    }

    private void initview() {
        news= (TextView) findViewById(R.id.news_tab);
        joke= (TextView) findViewById(R.id.joke_tab);
        weather= (TextView) findViewById(R.id.weather_tab);
        my= (TextView) findViewById(R.id.my_tab);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(0);
                news.setTextColor(Color.BLUE);
                news.setTextSize(30);
                joke.setTextColor(Color.WHITE);
                joke.setTextSize(30);
                weather.setTextColor(Color.WHITE);
                weather.setTextSize(30);
                my.setTextColor(Color.WHITE);
                my.setTextSize(30);
            }
        });
        joke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
                joke.setTextColor(Color.BLUE);
                joke.setTextSize(30);
                news.setTextColor(Color.WHITE);
                news.setTextSize(30);
                weather.setTextColor(Color.WHITE);
                weather.setTextSize(30);
                my.setTextColor(Color.WHITE);
                my.setTextSize(30);
            }
        });
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(2);
                weather.setTextColor(Color.BLUE);
                weather.setTextSize(30);
                joke.setTextColor(Color.WHITE);
                joke.setTextSize(30);
                news.setTextColor(Color.WHITE);
                news.setTextSize(30);
                my.setTextColor(Color.WHITE);
                my.setTextSize(30);
            }
        });
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(3);
                my.setTextColor(Color.BLUE);
                my.setTextSize(30);
                joke.setTextColor(Color.WHITE);
                joke.setTextSize(30);
                weather.setTextColor(Color.WHITE);
                weather.setTextSize(30);
                news.setTextColor(Color.WHITE);
                news.setTextSize(30);
            }
        });
    }

    private void initTopList() {
        pager= (ViewPager) findViewById(R.id.top_pager);
        NewFragment nf=new NewFragment();
        topList.add(nf);
        JokeFragment jf=new JokeFragment();
        topList.add(jf);
        WeatherFragment wf=new WeatherFragment();
        topList.add(wf);
        MyFragment mf=new MyFragment();
        topList.add(mf);
    }
}
