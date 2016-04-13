package newsapp.hugh.com.newsapplication.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;

/**
 * Created by hs on 2016/4/11.
 * 用来在Fragment的生命周期中定义执行模式。
 */
public abstract class BaseFragment extends Fragment {
    /*获取上下文，由于slidingfragment和contentfragment都在HomeActivity里面添加，
    所以直接获取HomeActivity可以方便使用*/
    HomeActivity mHA;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHA = (HomeActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*调用抽象方法初始化View*/
        View view = InitView();
        return view;
    }
    /*由于两个fragment没有共同的地方，所以定义一个抽象方法让子类必须重写去初始化view*/
    public abstract View InitView();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*调用初始化数据和事件的方法*/
        InitData();
        InitEvent();
    }
    /*定义两个方法来初始化数据和事件，子类不是必须实现的*/
    public void InitData(){}
    public void InitEvent(){}
}
