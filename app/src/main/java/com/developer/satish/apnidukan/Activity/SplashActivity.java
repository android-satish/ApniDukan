package com.developer.satish.apnidukan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.developer.satish.apnidukan.R;

public class SplashActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // getSupportActionBar().hide();
        sharedPreferences=getSharedPreferences("logindata",MODE_PRIVATE);
       // editor=sharedPreferences.edit();
       String loginmobile= sharedPreferences.getString("loginmobile","");
       String loginpin= sharedPreferences.getString("loginpin","");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(loginmobile !=null && loginpin !=null)
                {
                    Intent in=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(in);
                    finish();
                }else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                }
        },3000);
    }
}