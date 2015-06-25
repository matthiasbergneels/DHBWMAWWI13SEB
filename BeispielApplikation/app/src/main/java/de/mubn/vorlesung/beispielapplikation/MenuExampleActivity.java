package de.mubn.vorlesung.beispielapplikation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MenuExampleActivity extends ActionBarActivity {

    private final String LOG_TAG = MenuExampleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_example);
    }

    @Override
    protected void onStart() {
        super.onStart();

        registerForContextMenu(findViewById(R.id.btn_contextmenu));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(v.getId() == R.id.btn_contextmenu){
            getMenuInflater().inflate(R.menu.menu_menu_exmaple_button, menu);
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        if(itemId == R.id.btn_context1){
            Helper.logAndToast(this, LOG_TAG, "Context Menu Button 1");
            return true;
        }else if(itemId == R.id.btn_context2){
            Helper.logAndToast(this, LOG_TAG, "Context Menu Button 2");
            return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_example, menu);
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
        } else if(id == R.id.action_add){
            Helper.logAndToast(this, LOG_TAG, "Menu Button 'add' pressed");
        }

        return super.onOptionsItemSelected(item);
    }


}
