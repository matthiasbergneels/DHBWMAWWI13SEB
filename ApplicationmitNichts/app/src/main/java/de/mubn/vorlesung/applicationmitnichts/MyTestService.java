package de.mubn.vorlesung.applicationmitnichts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyTestService extends Service {

    public static final String SERVICE_BROADCAST_ACTION = "de.mubn.vorlesung.applicationmitnichts.action.SERVICE_ACTION";
    public static final String SERVICE_MESSAGE_KEY = "SERVICE_MESSAGE";

    private Timer myTimer;
    private long startTime;

    private TimerTask myTimerTask = new TimerTask() {
        @Override
        public void run() {

            long currenTime = System.currentTimeMillis();

            String message = "Service runs since " + ((currenTime - startTime)/1000);

            Intent i = new Intent(SERVICE_BROADCAST_ACTION);
            i.putExtra(SERVICE_MESSAGE_KEY, message);

            sendBroadcast(i);

            Log.d(MyTestService.class.getSimpleName(), message);
        }
    };

    public MyTestService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        myTimer = new Timer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        startTime = System.currentTimeMillis();

        myTimer.scheduleAtFixedRate(myTimerTask, 0, 5000);

        Log.d(MyTestService.class.getSimpleName(), "Timer started!");

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        myTimer.cancel();

        Log.d(MyTestService.class.getSimpleName(), "Timer stopped!");

        super.onDestroy();
    }
}
