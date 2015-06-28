package de.mubn.vorlesung.beispielapplikation;

import android.content.Intent;
import android.os.Binder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ServiceExample extends ActionBarActivity {

    private static final String LOG_TAG = ServiceExample.class.getSimpleName();
    private Binder serviceBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onClick(View view){

        if(view.getId() == R.id.btn_start_service){
            startService(new Intent(this, MyTestService.class));
            Log.d(LOG_TAG, "Service started!");
        }else if(view.getId() == R.id.btn_stop_service){
            stopService(new Intent(this, MyTestService.class));
            Log.d(LOG_TAG, "Service stopped");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_service_example, menu);
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
