package com.example.crosstheroad;

import android.os.Bundle;
import android.os.Handler;
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

        // blue = 0, green = 1,yellow = 2;
        if (spriteInt == 0) {
            imageView.setImageResource(R.drawable.blue_up);
        } else if (spriteInt == 1) {
            imageView.setImageResource(R.drawable.green_up);
        } else {
            imageView.setImageResource(R.drawable.yellow_up);
        }

        ImageView upArrowButton = view.findViewById(R.id.up_arrow);
        upArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your code here
                // This code will be executed when the ImageView is clicked
                int landing;
                ImageView character = view.findViewById(R.id.userCharacter);
                if (spriteInt == 0) {
                    character.setImageResource(R.drawable.blue_up1);
                    landing = R.drawable.blue_up;
                } else if (spriteInt == 1) {
                    character.setImageResource(R.drawable.green_up1);
                    landing = R.drawable.green_up;
                } else {
                    character.setImageResource(R.drawable.yellow_up1);
                    landing = R.drawable.yellow_up;
                }
                if (character.getY() > 300) {
                    character.setY(character.getY() - 60);
                }
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        character.setImageResource(landing);
                    }
                }, 200);
            }
        });
        ImageView bottomArrowButton = view.findViewById(R.id.bottom_arrow);
        bottomArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your code here
                // This code will be executed when the ImageView is clicked
                ImageView character = view.findViewById(R.id.userCharacter);
                int landing;
                if (spriteInt == 0) {
                    character.setImageResource(R.drawable.blue_down1);
                    landing = R.drawable.blue_down;
                } else if (spriteInt == 1) {
                    character.setImageResource(R.drawable.green_down1);
                    landing = R.drawable.green_down;
                } else {
                    character.setImageResource(R.drawable.yellow_down1);
                    landing = R.drawable.yellow_down;
                }
                if (character.getY() < 2000) {
                    character.setY(character.getY() + 60);
                }
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        character.setImageResource(landing);
                    }
                }, 200);
            }
        });
        ImageView rightArrowButton = view.findViewById(R.id.right_arrow);
        rightArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your code here
                // This code will be executed when the ImageView is clicked
                ImageView character = view.findViewById(R.id.userCharacter);
                int landing;
                if (spriteInt == 0) {
                    character.setImageResource(R.drawable.blue_right1);
                    landing = R.drawable.blue_right;
                } else if (spriteInt == 1) {
                    character.setImageResource(R.drawable.green_right1);
                    landing = R.drawable.green_right;
                } else {
                    character.setImageResource(R.drawable.yellow_right1);
                    landing = R.drawable.yellow_right;
                }
                if (character.getX() < 900) {
                    character.setX(character.getX() + 60);
                }
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        character.setImageResource(landing);
                    }
                }, 200);
            }
        });
        ImageView leftArrowButton = view.findViewById(R.id.left_arrow);
        leftArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your code here
                // This code will be executed when the ImageView is clicked
                ImageView character = view.findViewById(R.id.userCharacter);
                int landing;
                if (spriteInt == 0) {
                    character.setImageResource(R.drawable.blue_left1);
                    landing = R.drawable.blue_left;
                } else if (spriteInt == 1) {
                    character.setImageResource(R.drawable.green_left1);
                    landing = R.drawable.green_left;
                } else {
                    character.setImageResource(R.drawable.yellow_left1);
                    landing = R.drawable.yellow_left;
                }
                if (character.getX() > 100) {
                    character.setX(character.getX() - 60);
                }
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        character.setImageResource(landing);
                    }
                }, 200);
            }
        });

    }
}