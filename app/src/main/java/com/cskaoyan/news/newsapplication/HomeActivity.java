package com.cskaoyan.news.newsapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cskaoyan.news.newsapplication.fragment.ContentFragment;
import com.cskaoyan.news.newsapplication.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class HomeActivity extends SlidingFragmentActivity {

    private SlidingMenu slidingMenu;
    private LeftMenuFragment leftMenuFragment;
    private ContentFragment contentFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //
       /* TextView tv=new TextView(this);
        tv.setText("slidingmenu");
        tv.setBackgroundColor(Color.RED);
        setBehindContentView(tv);*/

        setBehindContentView(R.layout.layout_leftnemu);
        slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(340);


        final FragmentManager fragmentManager = getFragmentManager();

        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //
        leftMenuFragment = new LeftMenuFragment();
        contentFragment = new ContentFragment();
        fragmentTransaction.replace(R.id.fl_main_content, contentFragment,"contentfragment");

        fragmentTransaction.replace(R.id.ll_leftmenu_newsclass, leftMenuFragment,"leftmenufragment");


        fragmentTransaction.commit();

    }

    public void setSilidingMenuEnable(boolean enable){


        if (enable){

            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else
        {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }

    }


    public LeftMenuFragment getLeftMenuFragment(){

        //方法1 ，返回成员变量
        //return leftMenuFragment;

        FragmentManager fragmentManager = getFragmentManager();

        final LeftMenuFragment leftmenufragment = (LeftMenuFragment) fragmentManager.findFragmentByTag("leftmenufragment");

        return leftmenufragment;


    }

    public ContentFragment getContentFragment(){

        //方法1 ，返回成员变量
        //return leftMenuFragment;

        FragmentManager fragmentManager = getFragmentManager();

        final ContentFragment contentFragment = (ContentFragment) fragmentManager.findFragmentByTag("contentfragment");

        return contentFragment;


    }

    public void setSlidingMenuToggle(){
        slidingMenu.toggle();
    }
}
