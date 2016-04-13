package newsapp.hugh.com.newsapplication.Page;

import android.content.Context;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;

/**
 * Created by hs on 2016/4/12.
 */
public class SmartServicePage extends BasePage {

    public SmartServicePage(HomeActivity homeActivity) {
        super(homeActivity);
    }

    @Override
    public void InitData() {
        tv_basepage_name.setText("智慧服务");
        
    }
}
