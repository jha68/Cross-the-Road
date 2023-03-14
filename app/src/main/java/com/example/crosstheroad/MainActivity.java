package com.example.crosstheroad;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crosstheroad.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.crosstheroad.databinding.ActivityMainBinding binding =
                ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}