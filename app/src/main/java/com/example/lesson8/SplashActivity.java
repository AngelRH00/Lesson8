package com.example.lesson8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SplashActivity extends QuizActivity {
    private String TAG = "logear";
    private String LAST_LAUNCH = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        SharedPreferences lastTime = getSharedPreferences(LAST_LAUNCH, MODE_PRIVATE);
        Date now = new Date();
        /**
         * SimpleDateFormat has short text date, a space, short text month, a space, 2-digit
         * date, a space, hour(0-23), minute, second, a space, short timezone, a final space
         * and a long year
         */
        SimpleDateFormat format =
                new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        Log.i(TAG, "In QuizSplashActivity");
        if (lastTime.contains("dateTime") == true) {
            //We have recorded the last time we used the game
            String dateTime = lastTime.getString("dateTime", "Default");
            Log.i(TAG, "In QuizSplashActivity: " + dateTime);
        }
        SharedPreferences.Editor dateEditor = lastTime.edit();
        //dateEditor.putString("dateTime",
        // DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(now));
        //Using SimpleDateFormat: substitute the above second arg to ->>> format.format(now)
        dateEditor.putString("dateTime", format.format(now));
        dateEditor.commit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        animacion();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,QuizMenuActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }



    public void animacion() {
        ImageView icon = findViewById(R.id.icono);
        TextView titulo = findViewById(R.id.tituloUno);
        Animation animation_icono = AnimationUtils.loadAnimation(this, R.anim.fadein);
        Animation animation_titulo = AnimationUtils.loadAnimation(this, R.anim.show);
        icon.startAnimation(animation_icono);
        titulo.startAnimation(animation_titulo);
        SystemClock.sleep(2000);
    }
}
