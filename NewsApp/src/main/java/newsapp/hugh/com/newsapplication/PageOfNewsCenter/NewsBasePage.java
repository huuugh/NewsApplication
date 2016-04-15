package newsapp.hugh.com.newsapplication.PageOfNewsCenter;

import android.view.View;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;

/**
 * Created by hs on 2016/4/14.
 */
public abstract class NewsBasePage
{

    protected  HomeActivity homeActivity;
    protected  View rootview;

    public NewsBasePage(HomeActivity homeActivity)
    {
        this.homeActivity=homeActivity;
        this.rootview=InitView();
        InitEvent();
    }

    public void InitData()
    {
    }

    public abstract View InitView();

    public void InitEvent()
    {
    }

    public void swichpage(){}

    public View getRootview()
    {
        return rootview;
    }
}
