package com.busur.sketch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Animation zoom;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        img = findViewById(R.id.image);
        img.startAnimation(zoom);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (restorePrefData())
                {
                    Intent i = new Intent(getApplicationContext(), mainscreen.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(i);
                    finish();
                }
            }
        },4000);
    }


    private boolean restorePrefData()
    {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend", false);
        return isIntroActivityOpnendBefore;
    }
}