package practice.com.myapplication.scen_animation;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import practice.com.myapplication.R;


/**
 * Created by Dinesh.Sengar on 04-08-2016.
 */
public class SceneExample extends AppCompatActivity {

    ViewGroup rootContainer;
    Scene scene1;
    Scene scene2;


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_transitions);


        rootContainer = (ViewGroup) findViewById(R.id.rootContainer);

        scene1 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene1_layout, this);

        scene2 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene2_layout, this);

        scene2.enter();



    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void goToScene2 (View view)
    {
        Transition mFadeTransition = new AutoTransition();
        TransitionManager.go(scene2,mFadeTransition);

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void goToScene1 (View view)
    {
        Transition mSetTransition =
                TransitionInflater.from(this).inflateTransition(R.transition.trs);

        TransitionManager.go(scene1,mSetTransition);
    }
}
