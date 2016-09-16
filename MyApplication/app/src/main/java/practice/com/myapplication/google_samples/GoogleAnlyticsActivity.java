package practice.com.myapplication.google_samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import practice.com.myapplication.MyAplication;
import practice.com.myapplication.R;

/**
 * Created by dinesh.sengar on 31-08-2016.
 */
public class GoogleAnlyticsActivity extends AppCompatActivity {
    /**
     * The {@link Tracker} used to record screen views.
     */
    private Tracker mTracker;
    private static final String TAG = "GoogleAnlyticsActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_analytics);
        // [START shared_tracker]
        // Obtain the shared Tracker instance.
        MyAplication application = (MyAplication) getApplication();
        mTracker = application.getDefaultTracker();
        sendScreenImageName();

    }
    private void sendScreenImageName() {
        // [START screen_view_hit]
        mTracker.setScreenName("Screen" + TAG);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        // [END screen_view_hit]
    }

}
