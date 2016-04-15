package newsapp.hugh.com.newsapplication.PageOfHomeActivity;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;
import newsapp.hugh.com.newsapplication.Bean.NewsData4json;
import newsapp.hugh.com.newsapplication.Fragment.SlidingMenuFragment;
import newsapp.hugh.com.newsapplication.PageOfNewsCenter.Interact;
import newsapp.hugh.com.newsapplication.PageOfNewsCenter.News;
import newsapp.hugh.com.newsapplication.PageOfNewsCenter.NewsBasePage;
import newsapp.hugh.com.newsapplication.PageOfNewsCenter.Photos;
import newsapp.hugh.com.newsapplication.PageOfNewsCenter.Topic;

/**
 * Created by hs on 2016/4/12.
 */
public class NewsCenterPage extends BasePage {


    private static final String NEWSURL = "http://10.0.2.2/zhbj/categories.json";
    private String stringdata;
    private final List<NewsBasePage> newsCenterPages;
    private List<NewsData4json.NewsData> NewsDataList;
    private NewsBasePage newspage;

    public NewsCenterPage(HomeActivity homeActivity)
    {
        super(homeActivity);
        newsCenterPages = new ArrayList();
    }

    @Override
    public void InitData() {

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, NEWSURL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                stringdata = responseInfo.result;
                ParseData();
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Log.e("Http", "请求失败");
            }
        });
        tv_basepage_name.setText("新闻中心");
        /*使用来自leftFragment的接口*/
        homeActivity.getleftFragment().setOnswichpageLisenter(new SlidingMenuFragment.swichpageLisenter() {
            @Override
            public void swichpage(int position) {
                NewsCenterPage.this.swichpage(position);

                Log.e("NewsCenterPage", "" + position);
            }
        });
    }

    private void ParseData()
    {
        Gson gson = new Gson();
        NewsData4json newsData4json = gson.fromJson(stringdata, new NewsData4json().getClass());
        NewsDataList = newsData4json.data;
        (homeActivity.getleftFragment()).setMenuData(NewsDataList);

        /*根据侧边栏的顺序创建页面（鉴于服务器的数据可能和侧边栏的顺序不一致，所以要根据title来判断）*/
        for(NewsData4json.NewsData newsdata:NewsDataList)
        {
            switch (newsdata.title)
            {
                case "新闻":
                    newspage = new News(homeActivity,NewsDataList.get(0).children);
                    break;
                case "专题":
                    newspage = new Topic(homeActivity);
                    break;
                case "组图":
                    newspage = new Photos(homeActivity);
                    break;
                case "互动":
                    newspage = new Interact(homeActivity);
                    break;
                default:
                    break;
            }
            newsCenterPages.add(newspage);
        }

        Log.e("NewsDataList",""+NewsDataList.size());
        /*默认选择第一个*/
        swichpage(0);
    }

    public void swichpage(int position)
    {
        String title = NewsDataList.get(position).title;
        tv_basepage_name.setText(title);
        View rootview = newsCenterPages.get(position).getRootview();
        /*切换页面后先进行数据的初始化再进行显示*/
        newsCenterPages.get(position).InitData();
        fl_basepage_content.removeAllViews();
        fl_basepage_content.addView(rootview);
    }
}
