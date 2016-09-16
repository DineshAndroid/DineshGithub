package practice.com.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Dinesh.Sengar on 22-08-2016.
 */
public class MyReceiver extends BroadcastReceiver {
    private String TAG = MyReceiver.class.getSimpleName();

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle results = getResultExtras(true);
        String hierarchy = results.getString("hierarchy");
        Toast.makeText(context,"Hiii",Toast.LENGTH_SHORT).show();

        results.putString("hierarchy", hierarchy + "->" + TAG);

        Log.d(TAG, "MyReceiver");
    }
}
