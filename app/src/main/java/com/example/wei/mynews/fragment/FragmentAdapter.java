package com.example.wei.mynews.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wei on 2017/5/18.
 */
public class FragmentAdapter extends FragmentPagerAdapter{
    private List<String> mTitle=new ArrayList<>();
    private List<Fragment> mViews=new ArrayList<>();

//    public FragmentAdapter(FragmentManager fm, List<View> mViews, List<String> mTitle) {
//        super(fm);
//        this.mViews = mViews;
//        this.mTitle = mTitle;
//        Log.e("AAA","mTitle");
//    }
public FragmentAdapter(FragmentManager fm,List<Fragment> mViews, List<String> mTitle){
    super(fm);
    this.mViews = mViews;
    this.mTitle = mTitle;
}

    @Override
    public int getCount() {
        if(mViews == null){
            return 0;
        }
        return mViews.size();
    }


//    @Override
//    public Fragment getItem(int position) {
//
//            return mViews.get(position);
////return null;
//
//    }
    @Override
    public CharSequence getPageTitle(int position) {
        if(mTitle != null && position < mTitle.size()) {
            return mTitle.get(position);
        }
        return "notitle";
    }

    @Override
    public Fragment getItem(int position) {
        if (position<mViews.size()){
        return mViews.get(position);
        }
        else {
            return null;
        }
    }
}
