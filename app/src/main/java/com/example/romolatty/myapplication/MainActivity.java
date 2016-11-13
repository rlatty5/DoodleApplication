package com.example.romolatty.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {



    private Toolbar toolbar;                              // Declaring the Toolbar Object
    private Doodle doodle;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        //setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call

        doodle = (Doodle) findViewById(R.id.view);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            doodle.increaseSize();
            return true;
        }

        if (id == R.id.action_search) {
            doodle.chooseColor();
            return true;
        }

        if (id == R.id.action_user) {
            doodle.changeOpacity();
            return true;
        }

        if (id == R.id.clear) {
            doodle.clear();
            return true;
        }

        if (id == R.id.undo) {
            doodle.undo();
            return true;
        }

        if (id == R.id.random) {
            doodle.randomColor();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
