package com.apppartner.androidprogrammertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;


public class AnimationActivity extends ActionBarActivity {

    private ImageView appPartnerImageView;
    private ImageButton fadeButton;

    private Animation animationFadeIn;
    private Animation animationFadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        appPartnerImageView = (ImageView) findViewById(R.id.appPartnerImageView);
        fadeButton = (ImageButton) findViewById(R.id.fadeButton);
        animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out );

        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appPartnerImageView.startAnimation(animationFadeOut);

                //appPartnerImageView.startAnimation(animationFadeIn);
            }
        });


    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    public void onClickFade() {
//
//        fadeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                appPartnerImageView.startAnimation(animationFadeIn);
//            }
//        });
//    }
}
