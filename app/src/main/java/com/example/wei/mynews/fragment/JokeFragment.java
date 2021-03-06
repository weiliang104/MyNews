package com.example.wei.mynews.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wei.mynews.R;
import com.example.wei.mynews.adapter.Myadapter;
import com.example.wei.mynews.datas.JokeData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Wei on 2017/6/1.
 */

public class JokeFragment extends Fragment {
    private Myadapter mMyadapter;
    private List<JokeData.ResultBean.DataBean> mList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Handler mHandler;
    private final int BACK_CODE = 1001;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == BACK_CODE) {
                    mMyadapter.changeData(mList);
                }
                return false;
            }
        });
        mMyadapter=new Myadapter(mList);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main,container,false);
        getJokeData();
        mMyadapter = new Myadapter(mList);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycleview);
        mRecyclerView.setAdapter(mMyadapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void getJokeData() {
        String url = "http://japi.juhe.cn/joke/content/list.from?" +
                "key=7a979503b290b4ed8d3d30c219827280&page=2&pagesize=10&sort=asc&time=1418745237";
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("AAA", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                JokeData data = gson.fromJson(response.body().string(), JokeData.class);
                mList=data.getResult().getData();
                mHandler.sendEmptyMessage(BACK_CODE);
            }
        });
    }
}
