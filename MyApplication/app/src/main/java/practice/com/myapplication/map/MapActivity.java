package practice.com.myapplication.map;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import practice.com.myapplication.R;

/**
 * Created by Dinesh.Sengar on 17-08-2016.
 */
public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        //adding fragment
        SupportMapFragment  mapFragment= SupportMapFragment.newInstance();
        FragmentTransaction mFragmentTransaction=getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.frameContainer,mapFragment,null);
        mFragmentTransaction.commit();
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                

            }
        });
    }


}
