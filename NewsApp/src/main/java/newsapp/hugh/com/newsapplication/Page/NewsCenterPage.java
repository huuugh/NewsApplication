package newsapp.hugh.com.newsapplication.Page;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;
import newsapp.hugh.com.newsapplication.Bean.NewsData4json;
import newsapp.hugh.com.newsapplication.Fragment.SlidingMenuFragment;

/**
 * Created by hs on 2016/4/12.
 */
public class NewsCenterPage extends BasePage {


    private static final String NEWSURL = "http://10.0.2.2/zhbj/categories.json";
    private String stringdata;

    public NewsCenterPage(HomeActivity homeActivity) {
        super(homeActivity);
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
                Log.e("Http","请求失败");
            }
        });
        tv_basepage_name.setText("新闻中心");
    }

    private void ParseData()
    {
        Gson gson = new Gson();
        NewsData4json newsData4json = gson.fromJson(stringdata, new NewsData4json().getClass());
        (homeActivity.getleftFragment()).setMenuData(newsData4json.data);
    }
}
