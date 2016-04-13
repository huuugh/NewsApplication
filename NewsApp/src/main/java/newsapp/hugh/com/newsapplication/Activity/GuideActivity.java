package newsapp.hugh.com.newsapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import newsapp.hugh.com.newsapplication.R;

public class GuideActivity extends Activity {

    private ArrayList<PageInfo> pageInfolist;
    private Button bt_guide_enterhome;
    private ViewPager vp_guide_pic;
    private LinearLayout ll_guidepage_indicates;
    private View V_guidepage_redpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        vp_guide_pic = (ViewPager) findViewById(R.id.vp_guide_pic);
        bt_guide_enterhome = (Button) findViewById(R.id.bt_guide_enterhome);
        ll_guidepage_indicates = (LinearLayout) findViewById(R.id.ll_guidepage_indicates);
        V_guidepage_redpoint = (View) findViewById(R.id.V_guidepage_redpoint);

        pageInfolist = new ArrayList<>();
        int[] drawableRes = {R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
        /*添加页面*/
        for (int i=0;i<3;i++)
        {
            ImageView iv = new ImageView(this);
            iv.setImageResource(drawableRes[i]);
            PageInfo pageInfo = new PageInfo();
            pageInfo.mIV=iv;
            pageInfolist.add(pageInfo);
        }
        /*添加灰圆点*/
        for (int j=0;j<3;j++)
        {
            View graypoint = new View(this);
            graypoint.setBackgroundResource(R.drawable.guide_graypoint);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            if (j!=0)
            {
                params.leftMargin=20;
            }
            graypoint.setLayoutParams(params);
            ll_guidepage_indicates.addView(graypoint);
        }
        vp_guide_pic.setAdapter(new GVPageAdapter());
        vp_guide_pic.setOnPageChangeListener(new GuidePagechangeListener());

        bt_guide_enterhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this,HomeActivity.class));
                finish();
            }
        });
    }

    class GuidePagechangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) V_guidepage_redpoint.getLayoutParams();
            params.leftMargin= (int) (40*position+40*positionOffset);
            V_guidepage_redpoint.setLayoutParams(params);
        }

        @Override
        public void onPageSelected(int position) {
            if(position==2)
            {
                bt_guide_enterhome.setVisibility(View.VISIBLE);
            }
            else
            {
                bt_guide_enterhome.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class PageInfo
    {
        public ImageView mIV;
        public boolean isShowBtn;
    }

    class GVPageAdapter extends PagerAdapter
    {

        @Override
        public int getCount()
        {
            return pageInfolist.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==((PageInfo)object).mIV;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            PageInfo pageInfo = (PageInfo) object;
            container.removeView(pageInfo.mIV);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            PageInfo pageInfo = pageInfolist.get(position);
            container.addView(pageInfo.mIV);
            return pageInfo;
            /*return一个pageinfo给谁？*/
        }
    }
}
