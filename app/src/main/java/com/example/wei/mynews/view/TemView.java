package com.example.wei.mynews.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.example.wei.mynews.datas.Temperature;
import com.example.wei.mynews.datas.pointdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Wei on 2017/6/3.
 */

public class TemView extends View {
    private List<Temperature> mList = new ArrayList<>();
    private ArrayList<pointdata> mpointlist = new ArrayList<>();
    Paint mpaint = new Paint();

    public TemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTempList();
        calpoint();
    }

    public void calpoint() {
        for (int i = 0; i < mList.size(); i++) {
            int x = 50 + (i * 150);
            int lowx = (40 - mList.get(i).lowx) * 10;
            int highy = (40 - mList.get(i).hihty) * 10;
            pointdata pdata = new pointdata(x, lowx, highy);
            mpointlist.add(pdata);
        }

    }

    private void initTempList() {
        Temperature t1 = new Temperature(12, 26, new Date(2017, 5, 1));
        Temperature t2 = new Temperature(14, 32, new Date(2017, 5, 2));
        Temperature t3 = new Temperature(16, 29, new Date(2017, 5, 3));
        Temperature t4 = new Temperature(13, 31, new Date(2017, 5, 4));
        Temperature t5 = new Temperature(15, 28, new Date(2017, 5, 5));
        mList.add(t1);
        mList.add(t2);
        mList.add(t3);
        mList.add(t4);
        mList.add(t5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawPrant(canvas);
        drawLine(canvas);
        super.onDraw(canvas);
    }

    private void drawLine(Canvas canvas) {
        Path lowpath = new Path();
        Path highpath = new Path();
        for (int i = 0; i < mList.size(); i++) {
            if (i == 0) {
                lowpath.moveTo(mpointlist.get(0).x, mpointlist.get(0).lowy);
                highpath.moveTo(mpointlist.get(0).x, mpointlist.get(0).highy);
            } else
                lowpath.lineTo(mpointlist.get(i).x, mpointlist.get(i).lowy);
            highpath.lineTo(mpointlist.get(i).x, mpointlist.get(i).highy);
        }
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeWidth(5);
        mpaint.setColor(Color.RED);
        canvas.drawPath(lowpath, mpaint);
        mpaint.setColor(Color.BLUE);
        canvas.drawPath(highpath, mpaint);
    }

    private void drawPrant(Canvas canvas) {

        for (int i = 0; i < mList.size(); i++) {
            mpaint.setColor(Color.RED);
            canvas.drawCircle(mpointlist.get(i).x, mpointlist.get(i).lowy, 10, mpaint);
            mpaint.setColor(Color.BLUE);
            canvas.drawCircle(mpointlist.get(i).x, mpointlist.get(i).highy, 10, mpaint);
        }


    }
}
