package practice.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import practice.com.myapplication.broadcast.BroadCastRecieversSample;
import practice.com.myapplication.database.DBActivity;
import practice.com.myapplication.facebook.FacebookSampleActivity;
import practice.com.myapplication.fragment_lifecycle.FragmentLifeCycleActivity;
import practice.com.myapplication.google_samples.GPlusSample;
import practice.com.myapplication.google_samples.GoogleAnlyticsActivity;
import practice.com.myapplication.map.MapActivity;
import practice.com.myapplication.parcableexample.ParceableTestActivity;
import practice.com.myapplication.parcableexample.StudentRecords;
import practice.com.myapplication.scen_animation.AnimSampleActivity;
import practice.com.myapplication.services.MainService;
import practice.com.myapplication.twitter.TwitterSampleActivity;
import practice.com.myapplication.webapis.WebapiSample;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    StudentRecords records;
    private Tracker mTracker;
    private static final String TAG = "MainActivity";
    TextView tv;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // genrateKeyHash();


        //finding views
        Button btnCaching=(Button) findViewById(R.id.btn_caching);
        Button btnBroadCast=(Button) findViewById(R.id.btn_broad_cast);
        Button btnContentPro=(Button) findViewById(R.id.btn_cp);
        Button btnDb=(Button) findViewById(R.id.btn_db);
        Button btnAnim=(Button) findViewById(R.id.btn_anim);
        Button btn_map=(Button) findViewById(R.id.btn_map);
        Button btnFragment=(Button) findViewById(R.id.btn_fragment);
        Button btn_intnt_service=(Button) findViewById(R.id.btn_intnt_service);
        Button btn_perciable=(Button) findViewById(R.id.btn_perciable);
        Button btn_webAPi=(Button) findViewById(R.id.btn_webAPi);
        Button btn_G_plus=(Button) findViewById(R.id.btn_G_plus);
        Button btn_g_analytics=(Button) findViewById(R.id.btn_g_analytics);
        Button btn_crashlytics=(Button) findViewById(R.id.btn_crashlytics);
        Button btn_twitter=(Button) findViewById(R.id.btn_twitter);
        Button btn_facebook=(Button) findViewById(R.id.btn_facebook);

        //Setting Listener
        btnAnim.setOnClickListener(this);
        btnDb.setOnClickListener(this);
        btnContentPro.setOnClickListener(this);
        btnBroadCast.setOnClickListener(this);
        btnCaching.setOnClickListener(this);
        btn_map.setOnClickListener(this);
        btnFragment.setOnClickListener(this);
        btn_intnt_service.setOnClickListener(this);
        btn_perciable.setOnClickListener(this);
        btn_webAPi.setOnClickListener(this);
        btn_G_plus.setOnClickListener(this);
        btn_g_analytics.setOnClickListener(this);
        btn_crashlytics.setOnClickListener(this);
        btn_twitter.setOnClickListener(this);
        btn_facebook.setOnClickListener(this);


        //Google analytics

        MyAplication application = (MyAplication) getApplication();
        mTracker = application.getDefaultTracker();
        sendScreenImageName();
    }

    //Google analytics
    private void sendScreenImageName() {
        // [START screen_view_hit]
        mTracker.setScreenName("Screen" + TAG);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        // [END screen_view_hit]

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Share")
                .build());
        mTracker.enableAdvertisingIdCollection(true);
    }
/*
  private void  genrateKeyHash()
    {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "practice.com.myapplication",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }


    }*/

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case  R.id.btn_anim :

                Intent intentAnim=new Intent(this,AnimSampleActivity.class);
                startActivity(intentAnim);
                break;

            case  R.id.btn_broad_cast :
                Intent intentBroad=new Intent(this,BroadCastRecieversSample.class);
                startActivity(intentBroad);
                break;

            case  R.id.btn_caching :
                break;

            case  R.id.btn_webAPi :
                Intent intentAPI=new Intent(this, WebapiSample.class);
                startActivity(intentAPI);
                break;

            case  R.id.btn_cp :

                break;
            case  R.id.btn_map :
                Intent mapintent=new Intent(this,MapActivity.class);
                startActivity(mapintent);
                break;

            case  R.id.btn_perciable :
                records=new StudentRecords();
                records.name="Dinesh";
                Intent inttnt=new Intent(this, ParceableTestActivity.class);
                inttnt.putExtra("studentReocrd",records);
                startActivityForResult(inttnt,1);
                break;

            case  R.id.btn_intnt_service :
                Intent  intent=new Intent(this,MainService.class);
                startService(intent);
                break;

            case  R.id.btn_fragment :
                Intent fragemntIntent=new Intent(this, FragmentLifeCycleActivity.class);
                startActivity(fragemntIntent);
                break;

            case  R.id.btn_db :
                Intent dbIntent=new Intent(this, DBActivity.class);
                startActivity(dbIntent);
                break;

            case  R.id.btn_G_plus :
                Intent gplusIntent=new Intent(this, GPlusSample.class);
                startActivity(gplusIntent);
                break;

            case  R.id.btn_g_analytics :
                Intent gAnlytics=new Intent(this, GoogleAnlyticsActivity.class);
                startActivity(gAnlytics);
                break;

            case  R.id.btn_crashlytics :
                forceCrash();
/*
                try{
                    forceCrash();
                }catch (Exception e)
                {
                    Crashlytics.logException(e);
                }*/

                break;

            case  R.id.btn_twitter :

                Intent intent1=new Intent(this, TwitterSampleActivity.class);
                startActivity(intent1);
                break;

            case  R.id.btn_facebook :

                Intent intent2=new Intent(this, FacebookSampleActivity.class);
                startActivity(intent2);
                break;
        }
    }

    //Crashlytics

    public void forceCrash() {
        throw new RuntimeException("This is a crash");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
            Toast.makeText(this,"my name is "+records.name,Toast.LENGTH_LONG).show();
        }
    }
}
