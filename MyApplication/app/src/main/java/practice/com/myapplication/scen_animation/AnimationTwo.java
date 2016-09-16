package practice.com.myapplication.scen_animation;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import practice.com.myapplication.R;


/**
 * Created by Dinesh.Sengar on 04-08-2016.
 */
public class AnimationTwo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        Button btn_fadein=(Button)findViewById(R.id.btn_fadein);
        Button  btn_fadeout=(Button)findViewById(R.id.btn_fadeout);
        final Button  btn_animation=(Button)findViewById(R.id.btn_animation);

        btn_fadeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView spaceshipImage = (ImageView) findViewById(R.id.iv_ic_launcher);
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(AnimationTwo.this, R.anim.anim_sample);
                spaceshipImage.startAnimation(hyperspaceJumpAnimation);

            }
        });

        btn_fadein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_animation.animate().rotation(700).setStartDelay(5000).setDuration(7000).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Toast.makeText(AnimationTwo.this,"Hello Animation",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

            }
        });


    }



}

