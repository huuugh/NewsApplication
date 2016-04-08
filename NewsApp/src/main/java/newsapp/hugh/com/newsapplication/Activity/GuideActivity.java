package newsapp.hugh.com.newsapplication.Activity;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import newsapp.hugh.com.newsapplication.R;

public class GuideActivity extends Activity {

    private ArrayList<PageInfo> pageInfolist;
    private Button bt_guide_enterhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        ViewPager vp_guide_pic = (ViewPager) findViewById(R.id.vp_guide_pic);
        bt_guide_enterhome = (Button) findViewById(R.id.bt_guide_enterhome);

        pageInfolist = new ArrayList<>();
        int[] drawableRes = {R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
        for (int i=0;i<3;i++)
        {
            ImageView iv = new ImageView(this);
            iv.setImageResource(drawableRes[i]);
            PageInfo pageInfo = new PageInfo();
            pageInfo.mIV=iv;
            if (i==2)
            {
                pageInfo.isShowBtn=true;
            }
            else
            {
                pageInfo.isShowBtn=false;
            }
            pageInfolist.add(pageInfo);
        }

        vp_guide_pic.setAdapter(new GVPageAdapter());
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
            if (pageInfo.isShowBtn==true)
            {
                bt_guide_enterhome.setVisibility(View.VISIBLE);
            }
            else
            {
                bt_guide_enterhome.setVisibility(View.INVISIBLE);
            }
            container.addView(pageInfo.mIV);
            return pageInfo;
            /*return一个pageinfo给谁？*/
        }
    }
}
