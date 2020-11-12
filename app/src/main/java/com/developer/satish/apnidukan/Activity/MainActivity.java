package com.developer.satish.apnidukan.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.developer.satish.apnidukan.Fragments.BillingFragment;
import com.developer.satish.apnidukan.Fragments.BlankFragment;
import com.developer.satish.apnidukan.Fragments.HomeFragment;
import com.developer.satish.apnidukan.Fragments.ItemsFragment;
import com.developer.satish.apnidukan.Fragments.ManageCustomersFragment;
import com.developer.satish.apnidukan.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    FloatingActionButton floatingActionButton;
    NavigationView navigationView;
    Fragment managecutomerfragmet, homeFragment,itemsFragment,billingFragment,selectedFragment;

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_navigation_drawer);

        toolbar=findViewById(R.id.app_tool_bar);
        drawerLayout=findViewById(R.id.drawer);
        floatingActionButton=findViewById(R.id.floating_action_button);

        managecutomerfragmet=new ManageCustomersFragment();
        homeFragment=new HomeFragment();
        billingFragment=new BillingFragment();
        itemsFragment=new ItemsFragment();
        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.blank_fragment,homeFragment).commit();
        navigationView=findViewById(R.id.navigation_drawer_view);
        //navigation menu click open fragment
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.drawer_home:
                        selectedFragment=homeFragment;
                       //Toast.makeText(MainActivity.this,"Home Click",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.drawer_customer:
                        selectedFragment=managecutomerfragmet;
                        //Toast.makeText(MainActivity.this,"Customer Click",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.drawer_billing:
                        selectedFragment=billingFragment;
                        //Toast.makeText(MainActivity.this,"Billing Click",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.drawer_items:
                        selectedFragment=itemsFragment;
                       // Toast.makeText(MainActivity.this,"Item Click",Toast.LENGTH_LONG).show();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.blank_fragment,selectedFragment).commit();
               drawerLayout.closeDrawers();
                return true;
            }
        });
        //navigation drawer open icon click
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        //floating action button click
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.blank_fragment,managecutomerfragmet).commit();
            }
        });
        //toolbar top action menu open
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.top_action_profile:
                        Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                        startActivity(intent);
                       // Toast.makeText(MainActivity.this,"Profile Click",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.top_action_setting:
                        Intent intent1=new Intent(MainActivity.this,SettingsActivity.class);
                        startActivity(intent1);
                        //Toast.makeText(MainActivity.this,"Setting Click",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.top_action_logout:
                        MaterialAlertDialogBuilder dialogBuilder=new MaterialAlertDialogBuilder(MainActivity.this);
                        dialogBuilder.setTitle("Logout");
                        dialogBuilder.setIcon(R.drawable.ic_power_new_24);
                        dialogBuilder.setMessage("Are you want to logout?");
                        dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                              //  Toast.makeText(MainActivity.this,"Yes Click",Toast.LENGTH_LONG).show();
                            SharedPreferences sharedPreferences=getSharedPreferences("logindata",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.remove("loginmobile");
                            editor.remove("loginpin");

                            editor.clear();
                            editor.commit();

                            finish();
                            }
                        });
                        dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                 Toast.makeText(MainActivity.this,"No Click",Toast.LENGTH_LONG).show();
                            }
                        });
                        dialogBuilder.show();

                        break;
                }
                return false;
            }
        });
    }
}