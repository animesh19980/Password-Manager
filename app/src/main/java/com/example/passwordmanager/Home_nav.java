package com.example.passwordmanager;


import static com.example.passwordmanager.R.id;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.passwordmanager.databinding.ActivityHomeNavBinding;

public class Home_nav extends AppCompatActivity {

    ActivityHomeNavBinding binding;
    private MenuItem item;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        replaceFragment(new Check_Fragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == id.pass_Fragment) {
                replaceFragment(new Check_Fragment());
            } else if (item.getItemId() == id.gene_Fragment) {
                replaceFragment(new Gene_Fragment());
            }
            return true;
        });

    }


    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}