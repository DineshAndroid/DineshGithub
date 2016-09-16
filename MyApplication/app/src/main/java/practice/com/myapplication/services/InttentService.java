package practice.com.myapplication.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Dinesh.Sengar on 16-08-2016.
 */
public class InttentService extends IntentService {
    public InttentService() {
        super("InttentService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();

    }
}
