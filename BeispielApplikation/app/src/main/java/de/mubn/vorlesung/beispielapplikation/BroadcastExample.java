package de.mubn.vorlesung.beispielapplikation;

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

    private static final String  USER_BROADCAST_KEY = "USER_BROADCAST";
    private final String LOG_TAG = BroadcastExample.class.getSimpleName();

    public static final String BROADCAST_ACTION = "de.mubn.vorlesung.beispielapplikation.action.USERBROADCAST";

    private BroadcastReceiver myBatteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


            Bundle bundle = intent.getExtras();
            String info = "IntentAction: " + intent.getAction() + ";\n Extras and Values: ";
            for(String s:bundle.keySet()){
                info = info + "\n" + s + ": " + bundle.get(s).toString();
            }

            Log.d(LOG_TAG, info);
            String toastText = "Wrong Action!";
            if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
                toastText = "Battery level changed!";
            }else if(intent.getAction().equals(BROADCAST_ACTION)){
                toastText = bundle.getString(USER_BROADCAST_KEY);
            }

            Toast.makeText(BroadcastExample.this, toastText, Toast.LENGTH_LONG).show();
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

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(BROADCAST_ACTION);

        getApplicationContext().registerReceiver(myBatteryReceiver, filter);
    }

    @Override
    protected void onPause() {
        getApplicationContext().unregisterReceiver(myBatteryReceiver);
        super.onPause();

    }

    public void onClick(View view){

        Intent i = new Intent();

        i.setAction(BROADCAST_ACTION);
        i.putExtra(USER_BROADCAST_KEY, "User is spamming!");

        getApplicationContext().sendBroadcast(i);
    }
}
