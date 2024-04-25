package com.example.cameraxapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cameraxapp.MainActivity;
import com.example.cameraxapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    // Duration of the delay in milliseconds
    private static final long SPLASH_SCREEN_DELAY = 3000; // 3 seconds

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        ImageView logoImageView = findViewById(R.id.logoImageView);
        Animation zoomInAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        logoImageView.startAnimation(zoomInAnimation);

        zoomInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Animation started
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Animation ended, schedule transition after delay
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Start HomeActivity and finish splash screen activity
                        startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
                        finish();
                    }
                }, SPLASH_SCREEN_DELAY);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Animation repeated
            }
        });
    }
}
