package com.cskaoyan.news.newsapplication.page;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cskaoyan.news.newsapplication.R;

/**
 * Created by Lan on 2016/4/11.
 */
public abstract class BasePage {

    private View mRootView;

    protected  Activity mActivity;
    protected TextView tv_page_title;
    protected LinearLayout ll_page_content;
    protected ImageButton bt_page_left;
    protected ImageButton bt_page_rigth;

    public BasePage(Activity activity) {
        mActivity= activity;
        initView();
     }

    private void initView() {

        mRootView = View.inflate(mActivity, R.layout.page_mrootview,null);
        tv_page_title = (TextView) mRootView.findViewById(R.id.tv_page_title);
        ll_page_content = (LinearLayout) mRootView.findViewById(R.id.ll_page_content);
        bt_page_left = (ImageButton) mRootView.findViewById(R.id.bt_page_left);
        bt_page_rigth = (ImageButton) mRootView.findViewById(R.id.bt_page_rigth);

    }

    public abstract void initData();


    public View getmRootView() {
        return mRootView;
    }
}
