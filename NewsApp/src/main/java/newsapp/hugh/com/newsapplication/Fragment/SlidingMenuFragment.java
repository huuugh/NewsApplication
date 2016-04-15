package newsapp.hugh.com.newsapplication.Fragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import newsapp.hugh.com.newsapplication.Bean.NewsData4json;
import newsapp.hugh.com.newsapplication.R;

/**
 * Created by hs on 2016/4/11.
 */
public class SlidingMenuFragment extends BaseFragment {

    private ListView lv_slidingmenu_option;
    List<NewsData4json.NewsData> data=new ArrayList<>();
    private LeftMenuAdapter adapter;
    private int selecteditem;

    @Override
    public View InitView() {
        View view = View.inflate(mHA,R.layout.slidingmenu,null);
        lv_slidingmenu_option = (ListView) view.findViewById(R.id.lv_slidingmenu_option);
        return view;
    }

    public void setMenuData(List<NewsData4json.NewsData> data)
    {
        this.data=data;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void InitData() {
        adapter = new LeftMenuAdapter();
        lv_slidingmenu_option.setAdapter(adapter);
        lv_slidingmenu_option.setDividerHeight(0);
        super.InitData();
    }

    @Override
    public void InitEvent() {
        lv_slidingmenu_option.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selecteditem = position;
                adapter.notifyDataSetChanged();

                if (lisenter!=null)
                {
                    lisenter.swichpage(selecteditem);
                    Log.e("SlidingMenuFragment","收到");
                }
            }
        });
        super.InitEvent();
    }

    class LeftMenuAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return data.size();
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
            View view = View.inflate(mHA,R.layout.leftmenu_item,null);
            TextView tv_leftmenuitem_title = (TextView) view.findViewById(R.id.tv_leftmenuitem_title);
            tv_leftmenuitem_title.setText(data.get(position).title);
            tv_leftmenuitem_title.setEnabled(selecteditem==position);
            return view;
        }
    }

    /*写一个接口来给NewCenterPage调用，将侧边栏选中的按钮传递给NewCenterPage，用来决定显示哪个页面*/
    private swichpageLisenter lisenter;

    public interface swichpageLisenter
    {
        void swichpage(int position);
    }

    public void setOnswichpageLisenter(swichpageLisenter lisenter)
    {
        this.lisenter=lisenter;
    }

}
