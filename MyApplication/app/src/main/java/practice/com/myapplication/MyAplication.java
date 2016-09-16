package practice.com.myapplication;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.FacebookSdk;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Dinesh.Sengar on 16-08-2016.
 */
public class MyAplication extends Application {
    private Tracker mTracker;

    @Override
    public void onCreate() {
        super.onCreate();

        //Twitter Integration
        TwitterAuthConfig authConfig =  new TwitterAuthConfig("X4bGhvxKtfUlKZ4nNVKdHfnbK", "2vS7BwKJrux6W1zk18z2Za7DEJhyRH6OxVQdkCzsQCUwWv2Ry6");
        //CrashLitics

        Fabric.with(getApplicationContext(), new Crashlytics(), new TwitterCore (authConfig));
        logUser();

        //Facebook
        FacebookSdk.sdkInitialize(getApplicationContext());

        // initalize Calligraphy
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("source-sans-pro.light-italic.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );}


    //Google analytics

        /**
         * Gets the default {@link Tracker} for this {@link Application}.
         * @return tracker
         */
        synchronized public Tracker getDefaultTracker() {
            if (mTracker == null) {
                GoogleAnalytics analytics = GoogleAnalytics.getInstance(getApplicationContext());
                // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
                mTracker = analytics.newTracker(R.xml.global_tracker);
            }
            return mTracker;
        }

    //Crashlytics
    private void logUser() {
        // TODO: Use the current user's information
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier("9999999");
        Crashlytics.setUserName("Dinesh User");

    }

}
