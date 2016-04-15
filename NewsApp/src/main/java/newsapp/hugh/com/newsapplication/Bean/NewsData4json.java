package newsapp.hugh.com.newsapplication.Bean;

import java.util.List;

/**
 * Created by hs on 2016/4/12.
 * 将json中的数据进行封装，属性为所用属性的交集，如果某个数据为空则会被忽略
 */
public class NewsData4json
{
    public String retcode;
    public List<NewsData> data;

    public class NewsData
    {
        public List<Tagdata> children;

        public class Tagdata
        {
            public String id;
            public int type;
            public String title;
            public String url;
        }

        public String id;
        public String title;
        public int type;
        public String url;
        public String url1;
        public String dayur1;
        public String excur1;
        public String weekur1;
    }

    public List<String> extend;
}
