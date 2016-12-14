package allconnected.co.registerreceivertest;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static final String TAG = "Service_test";
    private static String action = "com.com";
    private boolean mIsRegistered;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        registerReceiver(mYReceiver, new IntentFilter(action));
        mIsRegistered = true;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mYReceiver != null) {
            unregisterReceiver(mYReceiver);
            mYReceiver = null;
        }
        if (mYReceiver != null) {
            unregisterReceiver(mYReceiver);
            mYReceiver = null;
        }
//        Log.d(TAG, "onDestroy: ");
//
//        if (mIsRegistered && mYReceiver != null) {
//            unregisterReceiver(mYReceiver);
//            mIsRegistered = false;
//        }
    }

    BroadcastReceiver mYReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };
}
