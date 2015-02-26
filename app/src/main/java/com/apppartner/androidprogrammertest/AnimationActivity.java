package com.apppartner.androidprogrammertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View.OnTouchListener;


public class AnimationActivity extends ActionBarActivity implements OnTouchListener {

    private ImageView appPartnerImageView;
    private ImageButton fadeButton;

    //private Animation animationFadeIn;
    private Animation animationFadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        // Enabling Back Button in the ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.btn_back);
        getSupportActionBar().setHomeButtonEnabled(true);

        appPartnerImageView = (ImageView) findViewById(R.id.appPartnerImageView);
        fadeButton = (ImageButton) findViewById(R.id.fadeButton);
        //animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out );

        appPartnerImageView.setOnTouchListener(this);

        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appPartnerImageView.startAnimation(animationFadeOut);

                //appPartnerImageView.startAnimation(animationFadeIn);
            }
        });


    }

    // Variables for Drag and Drop
    float x,y=0.0f;
    boolean moving = false;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch(motionEvent.getAction()){

            case MotionEvent.ACTION_DOWN:
                moving = true;
                break;

            case MotionEvent.ACTION_MOVE:

                // Getting here means moving = true

                x = motionEvent.getRawX() - appPartnerImageView.getWidth()/2;
                y = motionEvent.getRawY() - appPartnerImageView.getHeight()*3/2;

                appPartnerImageView.setX(x);
                appPartnerImageView.setY(y);
                break;

            case MotionEvent.ACTION_UP:
                moving = false;
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }



}
