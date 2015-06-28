package de.mubn.vorlesung.applicationmitnichts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class BroadcastExample extends ActionBarActivity {

    public static final String BROADCAST_ACTION = "de.mubn.vorlesung.applicationmitnichts.action.USER_SPAM";
    public static final String BROADCAST_KEY = "BROADCAST_MESSAGE";


    BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle extras = intent.getExtras();
            Log.d(BroadcastExample.class.getSimpleName(), "Received Broadcast: " + intent.getAction());
            for(String key:extras.keySet()){
                Log.d(BroadcastExample.class.getSimpleName(), key + ": " + extras.get(key).toString());
            }

            if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
                Toast.makeText(context, "Received Broadcast: " + intent.getAction(), Toast.LENGTH_LONG).show();
            }else if(intent.getAction().equals(BROADCAST_ACTION)){
                Toast.makeText(context, "Message: " + intent.getExtras().get(BROADCAST_KEY), Toast.LENGTH_LONG).show();
            }else if(intent.getAction().equals(MyTestService.SERVICE_BROADCAST_ACTION)){
                Toast.makeText(context, "Message: " + intent.getExtras().get(MyTestService.SERVICE_MESSAGE_KEY), Toast.LENGTH_LONG).show();
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_example);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_broadcast_example, menu);
        return true;
    }

    @Override
    protected void onResume() {

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(BROADCAST_ACTION);
        filter.addAction(MyTestService.SERVICE_BROADCAST_ACTION);

        registerReceiver(myReceiver, filter);

        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(myReceiver);

        super.onPause();
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

        Intent braodcastIntent = new Intent();
        braodcastIntent.setAction(BROADCAST_ACTION);

        braodcastIntent.putExtra(BROADCAST_KEY, "User spam");

        sendBroadcast(braodcastIntent);


    }
}
