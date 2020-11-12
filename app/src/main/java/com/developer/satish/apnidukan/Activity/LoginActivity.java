package com.developer.satish.apnidukan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.developer.satish.apnidukan.R;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private TextView userregisterTxt;
    TextInputLayout loginmobile, loginpin;
    Button loginButton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginmobile=findViewById(R.id.user_mobile_login);
        loginpin=findViewById(R.id.user_pin_login);
        loginButton=findViewById(R.id.user_login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String strloginmobile= loginmobile.getEditText().getText().toString();
               String strloginpin= loginpin.getEditText().getText().toString();
               if(TextUtils.isEmpty(strloginmobile))
               {
                   loginmobile.requestFocus();
                   loginmobile.setError("Please Fill The Field");
               }else if(TextUtils.isEmpty(strloginpin))
               {
                   loginpin.requestFocus();
                   loginpin.setError("Please Fill The Field");
               }else
               {
                   sharedPreferences=getSharedPreferences("logindata",MODE_PRIVATE);
                   editor=sharedPreferences.edit();
                   editor.putString("loginmobile",strloginmobile);
                   editor.putString("loginpin",strloginpin);
                   editor.apply();
                   editor.commit();

                   Intent in=new Intent(LoginActivity.this,MainActivity.class);
                   startActivity(in);
                   finish();
               }
            }
        });

        userregisterTxt=findViewById(R.id.userregisterBtn);
        userregisterTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}