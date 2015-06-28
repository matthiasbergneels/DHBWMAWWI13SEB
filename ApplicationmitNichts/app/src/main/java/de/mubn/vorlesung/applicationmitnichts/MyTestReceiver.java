package de.mubn.vorlesung.applicationmitnichts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyTestReceiver extends BroadcastReceiver {
    public MyTestReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();
        Log.d(BroadcastExample.class.getSimpleName(), "Received Broadcast: " + intent.getAction());
        for(String key:extras.keySet()){
            Log.d(BroadcastExample.class.getSimpleName(), key + ": " + extras.get(key).toString());
        }

        Toast.makeText(context, "Airplane mode changed!", Toast.LENGTH_LONG).show();

        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
