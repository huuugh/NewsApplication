package newsapp.hugh.com.newsapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import newsapp.hugh.com.newsapplication.Applacation.DataShare;
import newsapp.hugh.com.newsapplication.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RelativeLayout rl_splash_layout = (RelativeLayout) findViewById(R.id.rl_splash_layout);
        AnimationSet mAS = new AnimationSet(true);
        ScaleAnimation mSA = new ScaleAnimation(0, 1,0,1,Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        AlphaAnimation mAA = new AlphaAnimation(0, 1);
        mAS.addAnimation(mSA);
        mAS.addAnimation(mAA);
        mAS.setDuration(2000);
        rl_splash_layout.setAnimation(mAS);
        mAS.start();
        /*动画状态监听*/
        mAS.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(DataShare.getbooleandata("FirstOpen",true))
                {
                    DataShare.savebooleandata("FirstOpen",false);
                    startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                    finish();
                }
                else
                {
                    startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
