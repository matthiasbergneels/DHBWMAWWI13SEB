package de.mubn.vorlesung.beispielapplikation;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MyTestService extends Service {

    private final String LOG_TAG = MyTestService.class.getSimpleName();

    private MyTestServiceBinder binder = new MyTestServiceBinder();

    private Timer myTimer;
    private long startTime;

    public static final String SERVICE_ACTION = "de.mubn.volresung.beispielapplikation.action.SERVICE_SPAM";
    public static final String SERVICE_KEY = "SERVICE_MESSAGE";


    private TimerTask myTimerTask = new TimerTask() {
        @Override
        public void run() {
            long currentTime = System.currentTimeMillis();

            String message = "Service Running since: " + ((currentTime - startTime)/1000);
            Log.d(LOG_TAG, message);

            Intent i = new Intent();

            i.setAction(SERVICE_ACTION);
            i.putExtra(SERVICE_KEY, message);

            sendBroadcast(i);
        }
    };

    public class MyTestServiceBinder extends Binder{
      // Schnittstellenmethoden

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
        startTime = System.currentTimeMillis();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myTimer.scheduleAtFixedRate(myTimerTask, 0, 10000);

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        myTimer.cancel();

        super.onDestroy();
    }
}
