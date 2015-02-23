package com.apppartner.androidprogrammertest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
//                appPartnerImageView.startAnimation(animationFadeOut);
//
//                appPartnerImageView.startAnimation(animationFadeIn);

                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(appPartnerImageView, "alpha",  1f, 0.01f);
                fadeOut.setDuration(2000);
                ObjectAnimator fadeIn = ObjectAnimator.ofFloat(appPartnerImageView, "alpha", 0.01f, 1f);
                fadeIn.setDuration(2000);

                final AnimatorSet mAnimationSet = new AnimatorSet();

                mAnimationSet.play(fadeIn).after(fadeOut);

                mAnimationSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mAnimationSet.start();
                    }
                });
                mAnimationSet.start();
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
