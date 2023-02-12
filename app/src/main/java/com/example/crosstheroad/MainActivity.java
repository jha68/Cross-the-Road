package com.example.crosstheroad;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crosstheroad.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RadioGroup rg_difficulty;
    private RadioButton rb_easy, rb_normal, rb_hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        rg_difficulty = findViewById(R.id.rg_difficulty);
//        rb_easy = findViewById(R.id.button_easy);
//        rb_normal = findViewById(R.id.button_normal);
//        rb_hard = findViewById(R.id.button_hard);
//        rg_difficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (i == R.id.button_easy) {
//                    Toast.makeText(MainActivity.this, "EASY MODE", Toast.LENGTH_SHORT).show();
//                } else if (i == R.id.button_normal) {
//                    Toast.makeText(MainActivity.this, "NORMAL MODE", Toast.LENGTH_SHORT).show();
//                } else if (i == R.id.button_hard) {
//                    Toast.makeText(MainActivity.this, "HARD MODE", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}