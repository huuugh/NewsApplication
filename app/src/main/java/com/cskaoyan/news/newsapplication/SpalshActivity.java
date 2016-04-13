package com.cskaoyan.news.newsapplication;

 import android.app.Activity;
 import android.content.Intent;
 import android.content.SharedPreferences;
 import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
 import android.view.animation.AlphaAnimation;
 import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SpalshActivity extends Activity {

    private RelativeLayout rl_splash_bg;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        rl_splash_bg = (RelativeLayout) findViewById(R.id.rl_splash_bg);
        sp=getSharedPreferences("config",MODE_PRIVATE);

        AnimationSet as = new AnimationSet(true);

        RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);


        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        AlphaAnimation alphaAnimation= new AlphaAnimation(0,1);


        as.setDuration(2000);
        as.addAnimation(rotateAnimation);
        as.addAnimation(scaleAnimation);
        as.addAnimation(alphaAnimation);

        rl_splash_bg.setAnimation(as);
        as.start();

        as.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

               //第一次启动，显示guide，后面直接进入main

                if (sp.getBoolean("firsttime",true) ){
                    startActivity(new Intent(SpalshActivity.this,GuideActivity.class));
                    final SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("firsttime",false);
                    edit.commit();
                }else{
                    startActivity(new Intent(SpalshActivity.this,HomeActivity.class));

                }

                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
