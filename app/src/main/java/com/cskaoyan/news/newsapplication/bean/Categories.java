package com.cskaoyan.news.newsapplication.bean;

import java.util.ArrayList;

/**
 * Created by Lan on 2016/4/11.
 */
public class Categories {

    //1.类里需要赋值的成员变量名，必须和Json数据里的数据名一样。 如果你给的名字不一样，不会报错，该成员不会赋值。
    //2.如果你给的json对应的类里某个字段没有对应的 json值。并不会报错，只是不给这个字段赋值。
    //3.如果json数据里有这个字段，但是你的接受类里没有改字段对应的成员变量，也不会报错，只是不能把这个字段的值给你。

    public  int retcode;
    public  ArrayList<NewsTypeInfo>  data;

    public  class NewsTypeInfo{

        public   String title;
        public  int type;
        public  int id;
        public String url;
        public String url1;

        @Override
        public String toString() {
            return "NewsTypeInfo{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", url='" + url + '\'' +
                    ", url1='" + url1 + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "Categories{" +
                "data=" + data +
                ", retcode=" + retcode +
                '}';
    }
}
