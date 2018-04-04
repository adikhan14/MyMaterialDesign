package com.app.mymaterialdesign;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class TransitionActivity extends AppCompatActivity {

    Constants.TransitionType type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        initPage();

        initAnimation();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setAllowEnterTransitionOverlap(false);

    }

    private void initPage() {
        type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
        Button bExit = (Button) findViewById(R.id.button_exit);
        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    finishAfterTransition();
            }
        });

    }

    private void initAnimation() {

        switch (type) {
            case ExplodeJava:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode enterTransition = new Explode();
                    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                    getWindow().setEnterTransition(enterTransition);

                }
                break;
            case ExplodeXML:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                    getWindow().setEnterTransition(enterTransition);
                }
                break;
            case SlideJava:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Slide enterTransition = new Slide();
                    enterTransition.setSlideEdge(Gravity.TOP);
                    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                    enterTransition.setInterpolator(new FastOutLinearInInterpolator());
                    getWindow().setEnterTransition(enterTransition);
                }
                break;
            case SlideXML:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                    getWindow().setEnterTransition(enterTransition);
                }
                break;
            case FadeJava:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Fade enterTransition = new Fade();
                        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                        getWindow().setEnterTransition(enterTransition);
                    }

                }
                break;
            case FadeXML:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                    getWindow().setEnterTransition(enterTransition);
                }
                break;
        }

    }
}
