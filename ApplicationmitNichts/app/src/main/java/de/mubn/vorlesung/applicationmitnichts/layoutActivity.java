package de.mubn.vorlesung.applicationmitnichts;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class layoutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();

        switch (i.getExtras().getInt(RichtigeActivity.LAYOUT_ID)){
            case R.id.nav_table:
                setContentView(R.layout.table_layout);
                break;
            case R.id.nav_linear:
                setContentView(R.layout.linear_layout);
                break;
            case R.id.nav_relativ:
                setContentView(R.layout.relativ_layout);
                break;
            case R.id.nav_frame:
                setContentView(R.layout.frame_layout);
                break;
            case R.id.nav_absolut:
                setContentView(R.layout.absolut_layout);
                break;
            default:
                setContentView(R.layout.activity_layout);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_layout, menu);
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
}
