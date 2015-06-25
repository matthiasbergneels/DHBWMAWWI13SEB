package de.mubn.vorlesung.beispielapplikation;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by d041670 on 25.06.15.
 */
public class Helper {

    public static void logAndToast(Context context, String logTag, String text){

        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        Log.d(logTag, text);
    }
}
