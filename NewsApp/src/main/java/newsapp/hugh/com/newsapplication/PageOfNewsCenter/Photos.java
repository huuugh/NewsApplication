package newsapp.hugh.com.newsapplication.PageOfNewsCenter;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import newsapp.hugh.com.newsapplication.Activity.HomeActivity;

/**
 * Created by hs on 2016/4/14.
 */
public class Photos extends NewsBasePage {
    public Photos(HomeActivity homeActivity) {
        super(homeActivity);
    }

    @Override
    public View InitView()
    {
        TextView textView = new TextView(homeActivity);
        textView.setText("组图");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(30);
        return textView;
    }
}
