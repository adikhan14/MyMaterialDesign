package com.app.mymaterialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ContextualMenu extends AppCompatActivity {

    ActionMode actionMode;
    Button bContextualMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual_menu);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        bContextualMenu = (Button) findViewById(R.id.bContextualMenu);

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

       bContextualMenu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               actionMode = ContextualMenu.this.startActionMode(new ContextualCallback());
           }
       });
    }

    class ContextualCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            actionMode.getMenuInflater().inflate(R.menu.contextual_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            actionMode.setTitle("My Action Mode");
            actionMode.setSubtitle("by Adil");
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {

            // add functionality to Menu Item
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

            // Action is completed
        }
    }
}
