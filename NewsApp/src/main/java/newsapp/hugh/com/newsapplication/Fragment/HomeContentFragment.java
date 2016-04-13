package newsapp.hugh.com.newsapplication.Fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import newsapp.hugh.com.newsapplication.Page.BasePage;
import newsapp.hugh.com.newsapplication.Page.GovAffairPage;
import newsapp.hugh.com.newsapplication.Page.HomePage;
import newsapp.hugh.com.newsapplication.Page.NewsCenterPage;
import newsapp.hugh.com.newsapplication.Page.SettingPage;
import newsapp.hugh.com.newsapplication.Page.SmartServicePage;
import newsapp.hugh.com.newsapplication.R;

/**
 * Created by hs on 2016/4/11.
 */
public class HomeContentFragment extends BaseFragment {
    @ViewInject(R.id.vp_home_content)
    ViewPager viewPager;
    @ViewInject(R.id.rg_home_bottomtable)
    RadioGroup radioGroup;
    private ArrayList<BasePage> viewPagerList;
    private int currentselected;


    @Override
    public View InitView() {
        viewPagerList = new ArrayList<>();

        View view = View.inflate(mHA, R.layout.contentfragment, null);
        /*Xutil动态注入，省略了find view by id*/
        com.lidroid.xutils.ViewUtils.inject(this, view);
        return view;
    }

    @Override
    public void InitData() {
        /*将五个baseoage的子类加入到集合中，用于初始化viewpage的View*/
        viewPagerList.add(new HomePage(mHA));
        viewPagerList.add(new NewsCenterPage(mHA));
        viewPagerList.add(new SmartServicePage(mHA));
        viewPagerList.add(new GovAffairPage(mHA));
        viewPagerList.add(new SettingPage(mHA));
        /*设置主页viewpage的适配器*/
        viewPager.setAdapter(new HomepageAdapter());
        /*初始化数据时设置进入后显示第一页，第一个radioburtton被选中*/
        selectpage();
        radioGroup.check(R.id.rb_contentfragment_home);
    }

    /*判断选中的是RdioGroup的哪个键*/
    @Override
    public void InitEvent() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_contentfragment_home:
                        currentselected = 0;
                        break;
                    case R.id.rb_contentfragment_news:
                        currentselected = 1;
                        break;
                    case R.id.rb_contentfragment_samartservice:
                        currentselected = 2;
                        break;
                    case R.id.rb_contentfragment_govaffair:
                        currentselected = 3;
                        break;
                    case R.id.rb_contentfragment_setting:
                        currentselected = 4;
                        break;
                }
                selectpage();
            }
        });
    }

    /*更具选定的radiobutton来选择page，并设置能否划出侧边栏*/
    private void selectpage() {
        viewPager.setCurrentItem(currentselected);
        if (currentselected==0||currentselected==viewPagerList.size()-1||currentselected==viewPagerList.size()-2)
        {
            mHA.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
        else
        {
            mHA.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }
    }

    class HomepageAdapter extends PagerAdapter
    {
        @Override
        public int getCount() {
            return viewPagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePage basePage = viewPagerList.get(position);
            View view = basePage.getbasepage();
            container.addView(view);
            /*调用初始化数据的方法*/
            basePage.InitData();
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
