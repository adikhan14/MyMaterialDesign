package com.app.mymaterialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SharedElementActivity extends AppCompatActivity {

    private RelativeLayout revealDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);

        initPage();
    }

    private void initPage() {
        Button bExit = (Button) findViewById(R.id.button_exit);
        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    finishAfterTransition();
            }
        });

        revealDemo = (RelativeLayout) findViewById(R.id.click_reveal);
        revealDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCircularRevealAnimation(revealDemo);
            }
        });
    }

    public void makeCircularRevealAnimation(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            final TextView textviewDesc = (TextView) findViewById(R.id.textDesc);
            int centerX = (view.getLeft() + view.getRight()) / 2;
            int centerY = (view.getTop() + view.getBottom()) / 2;

            float radius = Math.max(textviewDesc.getWidth(), textviewDesc.getHeight()) * 2.0f;

            if (textviewDesc.getVisibility() == View.INVISIBLE) {

                textviewDesc.setVisibility(View.VISIBLE);
                textviewDesc.setText(R.string.detail_Description);

                ViewAnimationUtils.createCircularReveal(textviewDesc, centerX, centerY, 0, radius).start();

            } else {

                Animator reveal = ViewAnimationUtils.createCircularReveal(textviewDesc, centerX, centerY , radius, 0);
                reveal.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        textviewDesc.setVisibility(View.INVISIBLE);
                    }
                });

                reveal.start();
            }
        }
    }


}
