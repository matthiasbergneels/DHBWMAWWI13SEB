package de.mubn.vorlesung.beispielapplikation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){

        int viewId = view.getId();

        Log.d(LOG_TAG, "onClick for ID: " + viewId);

        Intent i;

        switch (viewId){
            case R.id.btn_navigation:
                logAndStartActivity(NavExamples.class);
                break;
            case R.id.btn_menu:
                logAndStartActivity(MenuExampleActivity.class);
                break;
            case R.id.btn_layout:
                logAndStartActivity(LayoutExamples.class);
                break;
            case R.id.btn_braodcast:
                logAndStartActivity(BroadcastExample.class);
                break;
        }
    }

    private void logAndStartActivity(Class cls){
        Intent i;
        Log.d(LOG_TAG, "Nav to " + cls.getSimpleName());
        i = new Intent(this, cls);
        startActivity(i);
    }
}
