package com.developer.satish.apnidukan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.developer.satish.apnidukan.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ProfileActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
MaterialToolbar materialToolbar;
TextView shopname,shopphone,shopaddress,ownername,owneraddress,ownermobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    materialToolbar=findViewById(R.id.top_prifileToolbar);


    shopname=findViewById(R.id.profile_shopname);
    shopphone=findViewById(R.id.profile_shopphone);
    shopaddress=findViewById(R.id.profile_shopaddress);
    ownername=findViewById(R.id.profile_ownername);
    ownermobile=findViewById(R.id.profile_ownermobile);
    owneraddress=findViewById(R.id.profile_owneraddress);
    materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent in=new Intent(ProfileActivity.this,MainActivity.class);
            startActivity(in);
            finish();
        }
    });

        sharedPreferences=getSharedPreferences("logindata",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        shopname.setText(sharedPreferences.getString("loginmobile",""));
    }
}