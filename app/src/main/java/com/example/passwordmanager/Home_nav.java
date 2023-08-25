package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.passwordmanager.databinding.ActivityHomeNavBinding;
import com.example.passwordmanager.databinding.ActivityMainBinding;

public class Home_nav extends AppCompatActivity {

    ActivityHomeNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding = ActivityHomeNavBinding.inflate(getLayoutInflater());
        binding.bottomNavigationView.setOnClickListener();

    }
}