package com.developer.satish.apnidukan.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.developer.satish.apnidukan.Models.RegistrationModel;

public class MyDatabaseHandler extends SQLiteOpenHelper {


    public MyDatabaseHandler(Context context) {
        super(context, ProjectConstants.DB_NAME, null, ProjectConstants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createRegistrationTable="CREATE TABLE IF NOT EXISTS registration(id INTEGER PRIMARY KEY AUTOINCREMENT, shopname TEXT,shopaddress TEXT, shopphone TEXT, ownername TEXT, owneraddress TEXT,ownermobile TEXT, shoppin Text)";
        db.execSQL(createRegistrationTable);

        String createCustomerTable="CREATE TABLE IF NOT EXISTS customer(id INTEGER PRIMARY KEY,name TEXT, mobile TEXT,address TEXT, balance TEXT,shopmobile TEXT, lastupdate TEXT)";
        db.execSQL(createCustomerTable);

        String createItemTable="CREATE TABLE IF NOT EXISTS item(id INTEGER PRIMARY KEY, name TEXT, description TEXT, mrp TEXT, discount TEXT, shopmobile TEXT)";
        db.execSQL(createItemTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String createRegistrationTable="CREATE TABLE IF NOT EXISTS registration(id INTEGER PRIMARY KEY AUTOINCREMENT, shopname TEXT,shopaddress TEXT, shopphone TEXT, ownername TEXT, owneraddress TEXT,ownermobile TEXT, shoppin Text)";
        db.execSQL(createRegistrationTable);

        String createCustomerTable="CREATE TABLE IF NOT EXISTS customer(id INTEGER PRIMARY KEY,name TEXT, mobile TEXT,address TEXT, balance TEXT,shopmobile TEXT, lastupdate TEXT)";
        db.execSQL(createCustomerTable);

        String createItemTable="CREATE TABLE IF NOT EXISTS item(id INTEGER PRIMARY KEY, name TEXT, description TEXT, mrp TEXT, discount TEXT, shopmobile TEXT)";
        db.execSQL(createItemTable);

    }
    public long saveRegistrationData(RegistrationModel registrationModel)
    {
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("shopname",registrationModel.getShopname());
        values.put("shopaddress",registrationModel.getShopaddress());
        values.put("shopphone",registrationModel.getShopphone());
        values.put("ownername",registrationModel.getOwnername());
        values.put("owneraddress",registrationModel.getOwneraddress());
        values.put("ownermobile",registrationModel.getOwnermobile());
        values.put("shoppin",registrationModel.getShoppin());
      long insertID = db.insert("registration",null,values);
      db.close();
      return  insertID;
    }
}
