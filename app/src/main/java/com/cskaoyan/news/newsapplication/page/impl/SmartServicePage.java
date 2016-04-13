package com.cskaoyan.news.newsapplication.page.impl;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.cskaoyan.news.newsapplication.HomeActivity;
import com.cskaoyan.news.newsapplication.page.BasePage;

/**
 * Created by Lan on 2016/4/11.
 */
public class SmartServicePage extends BasePage{


    public SmartServicePage(Activity activity) {
        super(activity);
    }



    @Override
    public void initData() {
        tv_page_title.setText("服务");

        ll_page_content.removeAllViews();

        TextView tv= new TextView(mActivity);
        tv.setText("服务内容" );
        tv.setGravity(Gravity.CENTER);
        
        ll_page_content.addView(tv);

        //禁用侧边栏
        HomeActivity homeActivity = (HomeActivity) mActivity;
        homeActivity.setSilidingMenuEnable(false);
        bt_page_left.setVisibility(View.INVISIBLE);
        bt_page_rigth.setVisibility(View.INVISIBLE);
    }


}
