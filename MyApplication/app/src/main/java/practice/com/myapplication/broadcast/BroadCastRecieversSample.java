package practice.com.myapplication.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import practice.com.myapplication.R;


/**
 * Created by Dinesh.Sengar on 22-08-2016.
 */
public class BroadCastRecieversSample extends AppCompatActivity {

    private static final String TAG = BroadCastRecieversSample.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }

    public  void normal(View view)
    {
        Intent intent = new Intent("com.pycitup.BroadcastReceive");
        sendBroadcast(intent);
    }


    public void ordred(View view) {
        IntentFilter filter = new IntentFilter("com.pycitup.BroadcastReceive");
// filter.setPriority(10); // could do this if you want to
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle results = getResultExtras(true);
                String hierarchy = results.getString("hierarchy");

                results.putString("hierarchy", hierarchy + "->" + TAG);
                Log.d(TAG, "Anonymous class broadcast receiver");
            }
        }, filter);

        Intent intent = new Intent("com.pycitup.BroadcastReceive");

        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle results = getResultExtras(true);
                String hierarchy = results.getString("hierarchy");

                System.out.println(hierarchy);
                Log.d(TAG, "Final Receiver");
            }
        }, null, Activity.RESULT_OK, null, null);

    }
}
