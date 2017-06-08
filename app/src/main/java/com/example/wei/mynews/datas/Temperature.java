package com.example.wei.mynews.datas;

import java.util.Date;

/**
 * Created by Wei on 2017/6/3.
 */

public class Temperature {
    public int lowx;
    public int hihty;
    private Date mDate;

    public Temperature(int lowx, int hihty, Date date) {
        this.lowx = lowx;
        this.hihty = hihty;
        mDate = date;
    }


}
