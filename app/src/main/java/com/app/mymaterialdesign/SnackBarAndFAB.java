package com.app.mymaterialdesign;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class SnackBarAndFAB extends AppCompatActivity {

    CoordinatorLayout rootLayout;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar_and_fab);

        rootLayout = (CoordinatorLayout) findViewById(R.id.root_layout);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootLayout, "FAB Clicked", Snackbar.LENGTH_LONG).show();

            }
        });

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("My SnackBar and FAB");
        mToolbar.setSubtitle("By Adil");

        mToolbar.inflateMenu(R.menu.snackbar_menu);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.simple_snackbar:
                        Snackbar.make(rootLayout, "Simple SnackBar", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.custom_snackbar:
                        break;
                    case R.id.action_snackbar:
                        Snackbar.make(rootLayout, "File Deleted", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(rootLayout, "File Restored", Snackbar.LENGTH_SHORT).show();
                            }
                        }).show();
                        break;
                }
                return true;
            }
        });
    }
}
