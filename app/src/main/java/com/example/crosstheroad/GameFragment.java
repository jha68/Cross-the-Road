package com.example.crosstheroad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {

    private double score;
    private int lives;
    private String name;
    private String difficulty;
    private String sprite;
    private int spriteInt;


    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        score = 0;
        lives = 0;
        name = "name";
        difficulty = "difficulty";
        sprite = "0";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Displaying the number of life
        TextView livesValue = view.findViewById(R.id.lives_value);
        lives = getArguments().getInt("lives");
        String livesString = String.valueOf(lives);
        livesValue.setText(livesString);

        // Displaying the user name
        TextView nameValue = view.findViewById(R.id.name_value);
        name = getArguments().getString("name");
        nameValue.setText(name);

        // Displaying the difficulty
        TextView difficultyValue = view.findViewById(R.id.difficulty_value);
        difficulty = getArguments().getString("difficulty");
        difficultyValue.setText(difficulty);

        // Default score
        TextView scoreValue = view.findViewById(R.id.score_value);
        String scoreString = String.valueOf(score);
        scoreValue.setText(scoreString);

        // Image changes depdends on user character
        ImageView imageView = view.findViewById(R.id.userCharacter);
        spriteInt = getArguments().getInt("spriteInt");

        // frog = 0, dog = 1,cat = 2;
        if (spriteInt == 0) {
            imageView.setImageResource(R.drawable.blue_frog);
        } else if (spriteInt == 1) {
            imageView.setImageResource(R.drawable.green_frog);
        } else {
            imageView.setImageResource(R.drawable.yellow_frog);
        }

        ImageView upArrowButton = view.findViewById(R.id.up_arrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your code here
                // This code will be executed when the ImageView is clicked
            }
        });

    }
}