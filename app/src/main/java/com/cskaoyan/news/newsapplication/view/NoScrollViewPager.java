package com.cskaoyan.news.newsapplication.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Lan on 2016/4/11.
 */
public class NoScrollViewPager extends ViewPager{
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    //让该控件无法滑动，无法处理滑动事件。


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return  false;   //super.onTouchEvent(ev);
    }
}
