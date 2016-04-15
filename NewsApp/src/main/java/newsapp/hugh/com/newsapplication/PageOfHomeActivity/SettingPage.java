package newsapp.hugh.com.newsapplication.PageOfHomeActivity;

import android.view.View;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;

/**
 * Created by hs on 2016/4/12.
 */
public class SettingPage extends BasePage {


    public SettingPage(HomeActivity homeActivity) {
        super(homeActivity);
    }

    @Override
    public void InitData() {
        ib_basepage_menu.setVisibility(View.INVISIBLE);
        tv_basepage_name.setText("设置中心");
    }
}
