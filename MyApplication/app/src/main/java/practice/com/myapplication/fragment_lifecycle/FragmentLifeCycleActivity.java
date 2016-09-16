package practice.com.myapplication.fragment_lifecycle;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import practice.com.myapplication.R;


/**
 * Created by dinesh.sengar on 08-08-2016.
 */
public class FragmentLifeCycleActivity extends AppCompatActivity {
    private String TAG=getClass().getName();

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity","onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Activity","onCreate");
        setContentView(R.layout.activity_fragment);
        //Sample for infalting fragment in layout

       FrameLayout frame_container=(FrameLayout)findViewById(R.id.frame_container);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(frame_container.getId(),new FrameLayoutContainFragment(),"Smaple");
        ft.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity","onDestroy");
    }
}
