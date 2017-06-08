package com.example.wei.mynews.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.wei.mynews.Myfragment;
import com.example.wei.mynews.R;
import com.example.wei.mynews.fragment.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private TabLayout mTableLayout;
    private ViewPager mViewPager;
    //    private TextView tv;
    private List<String> mTitle = new ArrayList<>();
    private List<Fragment> mViews = new ArrayList<>();
    private FragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTitle();
        initview();
        mTableLayout = (TabLayout) findViewById(R.id.tabview);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mViews, mTitle);
//        mViewPager.setAdapter(mAdapter);
    }

    private void initview() {
        for (int i=0;i<mTitle.size();i++){
    Fragment fragment=new Myfragment();
            Bundle bundle=new Bundle();
            bundle.putInt("NEWSTYPE", 1);
            fragment.setArguments(bundle);
        }
    }

    private void initTitle() {
        mTitle.add("推荐");
        mTitle.add("娱乐");
        mTitle.add("经济");
        mTitle.add("科技");
    }

}
