package com.developer.satish.apnidukan.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.developer.satish.apnidukan.R;

public class ManageCustomersFragment extends Fragment {
    Button addCustomerBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View rootView=inflater.inflate(R.layout.fragment_manage_customers, container, false);
         addCustomerBtn=rootView.findViewById(R.id.addcustomerButton);
         addCustomerBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                    Toast.makeText(getContext(),"Button Clicked",Toast.LENGTH_LONG).show();
             }
         });
        return rootView;
    }
}