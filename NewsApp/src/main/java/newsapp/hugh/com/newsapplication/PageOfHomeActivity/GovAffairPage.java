package newsapp.hugh.com.newsapplication.PageOfHomeActivity;

import android.view.View;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;

/**
 * Created by hs on 2016/4/12.
 */
public class GovAffairPage extends BasePage {

    public GovAffairPage(HomeActivity homeActivity) {
        super(homeActivity);
    }

    @Override
    public void InitData() {
        ib_basepage_menu.setVisibility(View.INVISIBLE);
        tv_basepage_name.setText("政务");
        
    }
}
