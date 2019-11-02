package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private  ImageView appLogo;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        findViews();
        createAnimation();
    }

    private void createAnimation() {

        Animation customFadeIn = AnimationUtils.loadAnimation(this,R.anim.splashscreenanimation);//get the animation we designed
        appLogo.startAnimation(customFadeIn);//start animation to the photo and title
        title.startAnimation(customFadeIn);
        //start a thread to let the animation
        createThreadForAnimation().start();
    }

    private void findViews() {

        appLogo = findViewById(R.id.imageView);
        title = findViewById(R.id.textView);
    }

    boolean checkIfTheUserIsLoggedIn(){

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key),MODE_PRIVATE);
        return sharedPreferences.getBoolean("LoggedIn",false);
    }

    private Thread createThreadForAnimation() {

        //timer to stay the splashScreen some sec.
        return new Thread(){

            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivityBasedOnUserLoggedIn();
                    finish();//dont show this if is pressed back
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private void startActivityBasedOnUserLoggedIn(){
        Intent intent;
        Log.d(getString(R.string.add), "startActivityBasedOnUserLoggedIn: " + checkIfTheUserIsLoggedIn());
        if(checkIfTheUserIsLoggedIn()){
            intent = new Intent(getApplicationContext(), MenuActivity.class);//start main activity
        }else {
            intent = new Intent(getApplicationContext(),LoginActivity.class);
        }
        finish();
        startActivity(intent);
    }
}