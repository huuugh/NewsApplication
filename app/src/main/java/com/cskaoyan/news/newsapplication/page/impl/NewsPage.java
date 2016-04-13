package com.cskaoyan.news.newsapplication.page.impl;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.cskaoyan.news.newsapplication.HomeActivity;
import com.cskaoyan.news.newsapplication.bean.Categories;
import com.cskaoyan.news.newsapplication.page.BasePage;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lan on 2016/4/11.
 */
public class NewsPage extends BasePage{


    private static final String TAG ="NewsPage" ;

    public NewsPage(Activity activity) {
        super(activity);
    }


    List<TextView> typelist;

    @Override
    public void initData() {
        tv_page_title.setText("新闻");


        ll_page_content.removeAllViews();
        TextView tv= new TextView(mActivity);
        tv.setText("新闻内容" );
        tv.setGravity(Gravity.CENTER);
        
        ll_page_content.addView(tv);


        //禁用侧边栏
        final  HomeActivity homeActivity = (HomeActivity) mActivity;
        homeActivity.setSilidingMenuEnable(true);

        bt_page_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                homeActivity.setSlidingMenuToggle();

            }
        });

        //在这里去想服务器拿数据
        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET, "http://10.0.2.2:8080/zhbj/categories.json", new RequestCallBack<String>() {

            private Categories categories;

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                final String result = responseInfo.result;
                Log.i(TAG,result);

                //Google json  =Gson

                Gson gson = new Gson();

                categories = gson.fromJson(result, Categories.class);

                ((HomeActivity) mActivity).getLeftMenuFragment().setCategories(categories);


//                Log.i(TAG,categories.toString());

                for (int i=0;i<categories.data.size();i++){

                    TextView tvvv= new TextView(mActivity);
                    tvvv.setText(categories.data.get(i).title+"类型");
                    tvvv.setGravity(Gravity.CENTER);
                    typelist.add(tvvv);

                }

            }

            @Override
            public void onFailure(HttpException e, String s) {

                Log.i(TAG,e.toString());
            }
        });

        typelist=new ArrayList<>();



     }


    public void setNewsType(int i){


        final TextView textView = typelist.get(i);

        ll_page_content.removeAllViews();
        ll_page_content.addView(textView);


    }

}
