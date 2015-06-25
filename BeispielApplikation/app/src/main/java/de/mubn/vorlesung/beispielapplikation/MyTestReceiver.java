package de.mubn.vorlesung.beispielapplikation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyTestReceiver extends BroadcastReceiver {

    private final String LOG_TAG = MyTestReceiver.class.getSimpleName();

    public MyTestReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Intentaction: " + intent.getAction(), Toast.LENGTH_LONG).show();

        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Bundle bundle = intent.getExtras();
            String info = "IntentAction: " + intent.getAction() + ";\n Extras and Values: ";
            for(String s:bundle.keySet()){
                info = info + "\n" + s + ": " + bundle.get(s).toString();
            }

            Log.d(LOG_TAG, info);

        }else{
            throw new UnsupportedOperationException("Not yet implemented");
        }

    }
}
