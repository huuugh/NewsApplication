package newsapp.hugh.com.newsapplication.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import newsapp.hugh.com.newsapplication.Fragment.HomeContentFragment;
import newsapp.hugh.com.newsapplication.Fragment.SlidingMenuFragment;
import newsapp.hugh.com.newsapplication.R;

/*继承SlidingFragmentActivity实现侧边栏*/
public class HomeActivity extends SlidingFragmentActivity {

    private static final String SLIDING_MENU ="slidingmenu";
    private static final String HOME_CONTENT ="homecontent";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        InitView();
        InitData();
    }

    /*用Fragment替换布局文件*/
    private void InitData()
    {
        FragmentManager mFM = getFragmentManager();
        FragmentTransaction transaction = mFM.beginTransaction();
        FragmentTransaction slidingmenu = transaction.replace(R.id.ll_slidingmenu_left, new SlidingMenuFragment(),SLIDING_MENU);
        FragmentTransaction content = transaction.replace(R.id.fl_homeactivity_layout, new HomeContentFragment(),HOME_CONTENT);
        transaction.commit();
    }

    private void InitView()
    {
        View view = View.inflate(this, R.layout.layout_slidingleft, null);
        setBehindContentView(view);
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(300);
    }

    public SlidingMenuFragment getleftFragment()
    {
        FragmentManager manager = getFragmentManager();
        SlidingMenuFragment leftfragment = (SlidingMenuFragment)manager.findFragmentByTag(SLIDING_MENU);
        return leftfragment;
    }

    public HomeContentFragment getcontentFragment()
    {
        FragmentManager manager = getFragmentManager();
        HomeContentFragment contentfragment = (HomeContentFragment)manager.findFragmentByTag(HOME_CONTENT);
        return contentfragment;
    }
}
