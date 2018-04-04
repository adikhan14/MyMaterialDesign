package com.app.mymaterialdesign;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationAndRippleEffects extends AppCompatActivity {

    ImageView imgAdilLogo, imgAdil;
    TextView tvSharedElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_and_ripple_effects);

        imgAdilLogo = (ImageView) findViewById(R.id.imgAdilLogo);
        imgAdil = (ImageView) findViewById(R.id.imgAdil);
        tvSharedElement = (TextView) findViewById(R.id.tvSharedElement);


        setupWindowAnimation();

    }

    private void setupWindowAnimation(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slideTransition = new Slide();
            slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
            slideTransition.setSlideEdge(Gravity.LEFT);

            getWindow().setReenterTransition(slideTransition);
            getWindow().setExitTransition(slideTransition);
            getWindow().setAllowReturnTransitionOverlap(false);
        }
    }

    public void checkRippleAnimation(View view) {
        Intent i = new Intent(AnimationAndRippleEffects.this, RippleAnimation.class);
        startActivity(i);

    }

    public void sharedElementTranistion(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Pair[] pair = new Pair[3];
            pair[0] = new Pair<View, String>(imgAdil, "profile_pic_shared");
            pair[1] = new Pair<View, String>(imgAdilLogo, "logo_shared");
            pair[2] = new Pair<View, String>(tvSharedElement, "friends_shared");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
            Intent i = new Intent(AnimationAndRippleEffects.this, SharedElementActivity.class);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(AnimationAndRippleEffects.this, SharedElementActivity.class);
            startActivity(i);
        }

    }

    public void explodeTransitionByCode(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
            startActivity(i);

        }

    }

    public void explodeTransitionByXML(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeXML);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeXML);
            startActivity(i);

        }


    }

    public void slideTransitionByCode(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideJava);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideJava);
            startActivity(i);
        }
    }

    public void slideTransitionByXML(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideXML);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideXML);
            startActivity(i);
        }
    }

    public void fadeTransitionByCode(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeJava);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeJava);
            startActivity(i);
        }

    }

    public void fadeTransitionByXML(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeXML);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(AnimationAndRippleEffects.this, TransitionActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeXML);
            startActivity(i);
        }
    }
}
