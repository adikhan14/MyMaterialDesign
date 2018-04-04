package com.app.mymaterialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by Adil khan on 1/29/2018.
 */

public class StandaloneToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Toolbar Tite");
        mToolbar.setSubtitle("by Adil");
        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.save:
                        break;
                    case R.id.email:
                        break;
                    case R.id.settings:
                        break;
                    case R.id.help:
                        break;
                    case R.id.camera:
                        break;
                    case R.id.webSearch:
                        break;
                }

                return true;
            }
        });

        // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        //    mToolbar.setElevation(10f);
        // }
    }
}
