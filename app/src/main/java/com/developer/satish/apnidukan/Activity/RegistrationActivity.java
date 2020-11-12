package com.developer.satish.apnidukan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.satish.apnidukan.Helper.MyDatabaseHandler;
import com.developer.satish.apnidukan.Models.RegistrationModel;
import com.developer.satish.apnidukan.R;
import com.google.android.material.textfield.TextInputLayout;

import static com.developer.satish.apnidukan.R.*;

public class RegistrationActivity extends AppCompatActivity {
    private TextView userLoginTxt;
   TextInputLayout shopname,shopaddress, shopphone,ownername,owneraddress,ownermobile,shoppin;
   private Button registerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_registration);
        userLoginTxt=findViewById(id.userloginBtn);

        userLoginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        shopname=findViewById(R.id.shopname);
        shopaddress=findViewById(R.id.shopaddress);
        shopphone=findViewById(R.id.shopmobile);
        ownername=findViewById(R.id.ownername);
        owneraddress=findViewById(id.owneraddress);
        ownermobile=findViewById(id.ownermobile);
        shoppin=findViewById(R.id.loginpin);
        registerBtn=findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrationModel registrationModel=new RegistrationModel(shopname.getEditText().getText().toString(),
                        shopaddress.getEditText().getText().toString(),
                        shopphone.getEditText().getText().toString(),
                        ownername.getEditText().getText().toString(),
                        owneraddress.getEditText().getText().toString(),
                        ownermobile.getEditText().getText().toString(),
                        shoppin.getEditText().getText().toString());


                MyDatabaseHandler  dbHandler=new MyDatabaseHandler(RegistrationActivity.this);
                long insertID=dbHandler.saveRegistrationData(registrationModel);
                if(insertID>0)
                {
                    Toast.makeText(RegistrationActivity.this, "Registration Succefully"+insertID, Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(RegistrationActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}