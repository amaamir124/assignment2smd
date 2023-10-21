package com.ass2.i200702_i200665;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static final long SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Use a Handler to post a delayed action to navigate to the login screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to navigate to the login activity
                Intent intent = new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
                finish(); // Finish the splash activity so the user can't go back to it
            }
        }, SPLASH_DURATION);
    }
}