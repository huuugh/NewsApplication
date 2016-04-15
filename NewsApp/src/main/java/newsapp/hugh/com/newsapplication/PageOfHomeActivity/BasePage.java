package newsapp.hugh.com.newsapplication.PageOfHomeActivity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;
import newsapp.hugh.com.newsapplication.R;

/**
 * Created by hs on 2016/4/12.
 */
public class BasePage {
    protected HomeActivity homeActivity;
    protected View basepage;
    protected ImageButton ib_basepage_menu;
    protected TextView tv_basepage_name;
    protected FrameLayout fl_basepage_content;
    //protected ImageButton ib_basepage_pic;

    public BasePage(HomeActivity homeActivity) {
        this.homeActivity=homeActivity;
        InitView();
        InitEvent();
    }

    /*给菜单按钮添加点击事件，打开或关闭侧边栏*/
    public void InitEvent() {
        ib_basepage_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity.getSlidingMenu().toggle();
            }
        });
    }

    public void InitData() {

    }

    protected void InitView() {
        basepage = View.inflate(homeActivity, R.layout.basepage_layout, null);
        ib_basepage_menu = (ImageButton) basepage.findViewById(R.id.ib_basepage_menu);
        tv_basepage_name = (TextView) basepage.findViewById(R.id.tv_basepage_name);
        fl_basepage_content = (FrameLayout) basepage.findViewById(R.id.fl_basepage_content);
        //ib_basepage_pic = (ImageButton) basepage.findViewById(R.id.ib_basepage_pic);
    }

    public View getbasepage()
    {
        return basepage;
    }
}
