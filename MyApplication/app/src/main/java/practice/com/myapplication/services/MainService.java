package practice.com.myapplication.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;

/**
 * Created by Dinesh.Sengar on 16-08-2016.
 */
public class MainService extends Service {

    private Looper  servioceLopper;
    private ServiceHandler  serviceHandler;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service started",Toast.LENGTH_SHORT).show();
        Message msg = serviceHandler.obtainMessage();
        msg.arg1 = startId;
        serviceHandler.sendMessage(msg);
        // If we get killed, after returning from here, restart
        return START_STICKY;

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();

    }

    private  class  ServiceHandler extends Handler{
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            try {
                Thread.sleep(5000);
                Toast.makeText(getApplicationContext(),"sleep",Toast.LENGTH_SHORT).show();
            } catch (InterruptedException e) {
                // Restore interrupt status.
                Thread.currentThread().interrupt();
            }
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate() {
        HandlerThread  handlerThread=new HandlerThread("servicewith", Process.THREAD_PRIORITY_BACKGROUND);
        servioceLopper= handlerThread.getLooper();
        serviceHandler = new ServiceHandler(servioceLopper);
    }


}
