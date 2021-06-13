package com.example.test.botom_nav_test.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    ImageView bgapp, logo_splash;
    Animation bganim;
    Timer timer;
    Timer timer2; // variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bgapp = (ImageView) findViewById(R.id.bgapp);
        logo_splash = (ImageView) findViewById(R.id.logo_splash);

        YoYo.with(Techniques.BounceIn)
                .duration(1000)
                .repeat(5)
                .playOn(findViewById(R.id.logo_splash));

        timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                bganim = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_bg_anim);
                bgapp.animate().translationY(-1700).setDuration(800).setStartDelay(300);
                timer2.cancel();
            }
        },1000, 1000); // timer 1

        /*frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        clover = (ImageView) findViewById(R.id.clover);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);*/

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent (SplashActivity.this, MainActivity.class);
                startActivity(intent);
                timer.cancel();
                finish();
            }
        },2000,1000); // timer 2



    }
}