package com.example.wei.mynews.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Wei on 2017/6/1.
 */
public class Topadapter extends FragmentPagerAdapter{
    private List<Fragment> topList;
    public Topadapter(FragmentManager fm,List<Fragment> topList) {
        super(fm);
        this.topList=topList;
    }

    @Override
    public Fragment getItem(int position) {
        return topList.get(position);
    }

    @Override
    public int getCount() {
        return topList.size();
    }
}
