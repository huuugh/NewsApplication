package com.cskaoyan.news.newsapplication.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cskaoyan.news.newsapplication.HomeActivity;
import com.cskaoyan.news.newsapplication.R;
import com.cskaoyan.news.newsapplication.bean.Categories;
import com.cskaoyan.news.newsapplication.page.impl.NewsPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lan on 2016/4/11.
 */
public class LeftMenuFragment extends Fragment {


    private static final String TAG = "LeftMenuFragment";
    private ListView lv_slidingmenu_type;




    Categories categories;
    private MyleftMenulistAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



     /*   TextView tv = new TextView(getActivity());
        tv.setText("leftmenu");
        tv.setBackgroundColor(Color.RED);*/

        final View view = inflater.inflate(R.layout.slidingmenu,null);


        final HomeActivity homeActivity = (HomeActivity) getActivity();
        final ContentFragment contentFragment = homeActivity.getContentFragment();


        lv_slidingmenu_type = (ListView) view.findViewById(R.id.lv_slidingmenu_type);

        lv_slidingmenu_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                final NewsPage newsPage = contentFragment.getNewsPage();
                newsPage.setNewsType(position);
                homeActivity.setSlidingMenuToggle();
                final TextView tv = (TextView) view.findViewById(R.id.tv_menulistitem_category);
                tv.setEnabled(true);

            }
        });

/*
        newstypelist= new ArrayList<>();
        for (int i=0;i<4;i++){

            TextView tv= new TextView(getActivity());
            tv.setText("type"+i);
            newstypelist.add(tv);

        }*/



        return view;//.onCreateView(inflater, container, savedInstanceState);
    }


    class MyleftMenulistAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return categories.data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final View view = View.inflate(getActivity(), R.layout.menu_list_item, null);

            final TextView tv_menulistitem_category = (TextView) view.findViewById(R.id.tv_menulistitem_category);
            tv_menulistitem_category.setText(categories.data.get(position).title);
            return view;
        }
    }

    public void setCategories(Categories categories){

        this.categories=categories;

        adapter = new MyleftMenulistAdapter();
        lv_slidingmenu_type.setAdapter(adapter);


        Log.i(TAG,this.categories.toString());

    }
}
