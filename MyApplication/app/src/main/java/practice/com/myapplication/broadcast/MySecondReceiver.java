package practice.com.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Dinesh.Sengar on 22-08-2016.
 */
public class MySecondReceiver extends BroadcastReceiver {
    private String TAG = MySecondReceiver.class.getSimpleName();

    public MySecondReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle results = getResultExtras(true);
        results.putString("hierarchy", TAG);

        Log.d(TAG, "MySecondReceiver");
    }

}
