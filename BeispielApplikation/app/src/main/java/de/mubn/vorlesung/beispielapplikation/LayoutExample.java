package de.mubn.vorlesung.beispielapplikation;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class LayoutExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = getIntent().getExtras().getInt(LayoutExamples.KEY_LAYOUT_ID);

        setContentView(layoutId);
    }

}
