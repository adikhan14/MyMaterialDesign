package com.app.mymaterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void standaloneToolbar(View view) {
        Intent i = new Intent(MainActivity.this, StandaloneToolbar.class);
        startActivity(i);

    }

    public void toolbarAsActionbar(View view) {
        Intent i = new Intent(MainActivity.this, ActionbarToolbar.class);
        startActivity(i);

    }

    public void showContextualMenu(View view) {
        Intent i = new Intent(MainActivity.this, ContextualMenu.class);
        startActivity(i);

    }

    public void showSnackbarFab(View view) {
        Intent i = new Intent(MainActivity.this, SnackBarAndFAB.class);
        startActivity(i);

    }

    public void showAnimationRippleEffects(View view) {
        Intent i = new Intent(MainActivity.this, AnimationAndRippleEffects.class);
        startActivity(i);

    }
}
