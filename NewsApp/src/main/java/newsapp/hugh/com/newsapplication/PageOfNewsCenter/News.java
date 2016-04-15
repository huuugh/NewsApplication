package newsapp.hugh.com.newsapplication.PageOfNewsCenter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.viewpagerindicator.TabPageIndicator;

import java.util.List;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;
import newsapp.hugh.com.newsapplication.Bean.NewsData4json;
import newsapp.hugh.com.newsapplication.R;

/**
 * Created by hs on 2016/4/14.
 */
public class News extends NewsBasePage {
    private final List<NewsData4json.NewsData.Tagdata> children;

    public News(HomeActivity homeActivity, List<NewsData4json.NewsData.Tagdata> children) {
        super(homeActivity);
        this.children=children;
    }

    @ViewInject(R.id.pager)
    private ViewPager vp;
    @ViewInject(R.id.indicator)
    private TabPageIndicator tpi;

    @Override
    public View InitView() {

        View newsview = View.inflate(homeActivity, R.layout.news_layout,null);
        /*动态注入*/
        ViewUtils.inject(this, newsview);
        return newsview;
    }

    @Override
    public void InitData() {
        super.InitData();
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return children.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TextView tv = new TextView(homeActivity);
                tv.setText(children.get(position).title);
                tv.setTextSize(30);
                tv.setGravity(Gravity.CENTER);
                container.addView(tv);
                return tv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return children.get(position).title;
            }
        });
        /*此步骤必须在setAdapter之后，否则会报错*/
        tpi.setViewPager(vp);
    }
}
