package com.cskaoyan.news.newsapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {

    private static final String TAG ="GuideActivity" ;
    private ViewPager vp_guide_show;
//    List<ImageView>  imageViewList;

    List<MyPageInfo>  pageinfoList;
    private Button bt_guide_enter;
    private LinearLayout ll_guide_indicator;
    private View redpoint_guide_indicator;

    class MyPageInfo {

        ImageView iv;
        String pageTitle;

    }

    int[] imgid=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        vp_guide_show = (ViewPager) findViewById(R.id.vp_guide_show);
        bt_guide_enter = (Button) findViewById(R.id.bt_guide_enter);
        ll_guide_indicator = (LinearLayout) findViewById(R.id.ll_guide_indicator);

        redpoint_guide_indicator =
                findViewById(R.id.redpoint_guide_indicator);
//        imageViewList=new ArrayList<>();

        pageinfoList = new ArrayList<>();

        init();


        vp_guide_show.setAdapter(new MyPagerAdapter());
        vp_guide_show.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                 Log.i(TAG, position+":"+positionOffset+":"+positionOffsetPixels);

                 FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) redpoint_guide_indicator.getLayoutParams();

                //根据当前滑动的参数去觉得当前红点的位置
                layoutParams.leftMargin=position*40+  (int)(positionOffset*40);

                 redpoint_guide_indicator.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageSelected(int position) {

                //选中第三个page的时候，显示button. 点击button ，进入主页面

                Log.i(TAG,"onPageSelected"+ position);
                if (position==2){
                    bt_guide_enter.setVisibility(View.VISIBLE);
                }
                else {
                    bt_guide_enter.setVisibility(View.GONE);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    public void enterHome(View v){


        startActivity(new Intent(this,HomeActivity.class));
        finish();

    }

    private void init() {
        for (int i=0;i<3;i++){

            ImageView imageView = new ImageView(this);

            imageView.setImageResource(imgid[i]);

            final MyPageInfo myPageInfo = new MyPageInfo();

            myPageInfo.iv=imageView;
            myPageInfo.pageTitle="page"+i;

//          imageViewList.add(imageView);

            pageinfoList.add(myPageInfo);

        }


//       初始化指示器背景三个黑色小圆点
        for (int i=0;i<3;i++){

            View view = new View(this);
            view.setBackgroundResource(R.drawable.greypoint);

            //凡是代码中使用数字指定的宽高，默认都是像素
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
            if (i!=0)
                 params.leftMargin=20;

            view.setLayoutParams(params);

            ll_guide_indicator.addView(view);

        }

    }


    class MyPagerAdapter extends PagerAdapter{


        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            MyPageInfo pageInfo = (MyPageInfo) object;
            return view == pageInfo.iv;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

//            final ImageView imageView = imageViewList.get(position);

            final MyPageInfo myPageInfo = pageinfoList.get(position);
            container.addView(myPageInfo.iv);
            return   myPageInfo;
            //super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);

            MyPageInfo pageInfo = (MyPageInfo) object;
            container.removeView( pageInfo.iv);

        }
    }
}
