package com.example.crosstheroad;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {

    private double score;
    private int lives;
    private String name;
    private String difficulty;
    private String sprite;
    private int spriteInt;
    private double maxHeight = Double.POSITIVE_INFINITY;
    private int[] points = {5, 10, 15, 20};
    private int count = 0;




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
        setLives(getArguments().getInt("lives"));
        String livesString = String.valueOf(getLives());
        livesValue.setText(livesString);

        // Displaying the user name
        TextView nameValue = view.findViewById(R.id.name_value);
        setName(getArguments().getString("name"));
        nameValue.setText(getName());

        // Displaying the difficulty
        TextView difficultyValue = view.findViewById(R.id.difficulty_value);
        setDifficulty(getArguments().getString("difficulty"));
        difficultyValue.setText(getDifficulty());

        setUpLivesValue(view);
        setUpUsernameValue(view);
        setUpDifficultyValue(view);
        setUpScoreValue(view);
        setUpSprite(view);
        setUpArrowButtons(view);

    }


    private void setUpScoreValue(@NonNull View view) {
        // Default score
        TextView scoreValue = view.findViewById(R.id.score_value);
        String scoreString = String.valueOf(score);
        scoreValue.setText(scoreString);
    }

    private void setUpDifficultyValue(@NonNull View view) {
        // Displaying the difficulty
        TextView difficultyValue = view.findViewById(R.id.difficulty_value);
        setDifficulty(getArguments().getString("difficulty"));
        difficultyValue.setText(getDifficulty());
    }

    private void setUpUsernameValue(@NonNull View view) {
        // Displaying the user name
        TextView nameValue = view.findViewById(R.id.name_value);
        setName(getArguments().getString("name"));
        nameValue.setText(getName());
    }

    private void setUpLivesValue(@NonNull View view) {
        // Displaying the number of life
        TextView livesValue = view.findViewById(R.id.lives_value);
        setLives(getArguments().getInt("lives"));
        String livesString = String.valueOf(getLives());
        livesValue.setText(livesString);
    }

    private void setUpArrowButtons(@NonNull View view) {
        setUpUpButton(view);
        setUpDownButton(view);
        setUpRightButton(view);
        setUpLeftButton(view);
    }

    private void setUpUpButton(@NonNull View view) {
        ImageView upArrowButton = view.findViewById(R.id.up_arrow);
        upArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your code here
                // This code will be executed when the ImageView is clicked

                ImageView character = view.findViewById(R.id.userCharacter);
                ImageView goal1 = view.findViewById(R.id.goal_1);
                ImageView goal2 = view.findViewById(R.id.goal_2);
                ImageView goal3 = view.findViewById(R.id.goal_3);
                ImageView goal4 = view.findViewById(R.id.goal_4);
                ImageView goal5 = view.findViewById(R.id.goal_5);
                int goalWidth = goal1.getWidth();
                int goalHeight = goal1.getHeight();
                ImageView goalFrog = new ImageView(getContext());
                goalFrog.setImageResource(R.drawable.catched_frog);
                goalFrog.setLayoutParams(new ViewGroup.LayoutParams(
                        goalWidth, goalHeight
                ));
                int landing;
                if (getSpriteInt() == 0) {
                    character.setImageResource(R.drawable.blue_up1);
                    landing = R.drawable.blue_up;
                } else if (getSpriteInt() == 1) {
                    character.setImageResource(R.drawable.green_up1);
                    landing = R.drawable.green_up;
                } else {
                    character.setImageResource(R.drawable.yellow_up1);
                    landing = R.drawable.yellow_up;
                }

                if (character.getY() > 300) {
                    if (maxHeight > character.getY()) {
                        maxHeight = character.getY();
                        score += points[(int) maxHeight % 4];
                        TextView scoreValue = view.findViewById(R.id.score_value);
                        String scoreString = String.valueOf(score);
                        scoreValue.setText(scoreString);
                    }
                    character.setY(character.getY() - 155);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            character.setImageResource(landing);
                            if (character.getY() < 300) {
                                ImageView reset = view.findViewById(R.id.startCharacter);
                                character.setX(reset.getX());
                                character.setY(reset.getY());
                                maxHeight = Double.POSITIVE_INFINITY;
                            }
                        }
                    }, 200);
                    if (character.getY() < 300) {
                        if (character.getX() >= goal1.getX() &&
                                character.getX() + character.getWidth() <= goal1.getX() + goalWidth) {
                            goal1.setImageResource(R.drawable.catched_frog);
                        } else if (character.getX() >= goal2.getX() &&
                                character.getX() + character.getWidth() <= goal2.getX() + goalWidth) {
                            goal2.setImageResource(R.drawable.catched_frog);
                        } else if (character.getX() >= goal3.getX() &&
                                character.getX() + character.getWidth() <= goal3.getX() + goalWidth) {
                            goal3.setImageResource(R.drawable.catched_frog);
                        } else if (character.getX() >= goal4.getX() &&
                                character.getX() + character.getWidth() <= goal4.getX() + goalWidth) {
                            goal4.setImageResource(R.drawable.catched_frog);
                        } else if (character.getX() >= goal5.getX() &&
                                character.getX() + character.getWidth() <= goal5.getX() + goalWidth) {
                            goal5.setImageResource(R.drawable.catched_frog);
                        } else {
                            TextView livesValue = view.findViewById(R.id.lives_value);
                            setLives(getArguments().getInt("lives") - (++count));
                            String livesString = String.valueOf(getLives());
                            livesValue.setText(livesString);

                        }
                    }
                }





            }
        });

    }

    private void setUpDownButton(@NonNull View view) {

        ImageView bottomArrowButton = view.findViewById(R.id.bottom_arrow);
        bottomArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your code here
                // This code will be executed when the ImageView is clicked
                View rootView = view.getRootView();
                int height = rootView.getHeight();
                ImageView character = view.findViewById(R.id.userCharacter);
                int landing;
                if (getSpriteInt() == 0) {
                    character.setImageResource(R.drawable.blue_down1);
                    landing = R.drawable.blue_down;
                } else if (getSpriteInt() == 1) {
                    character.setImageResource(R.drawable.green_down1);
                    landing = R.drawable.green_down;
                } else {
                    character.setImageResource(R.drawable.yellow_down1);
                    landing = R.drawable.yellow_down;
                }

                if (character.getY() < height - 300) {
                    character.setY(character.getY() + 155);
                }

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        character.setImageResource(landing);
                    }
                }, 200);
            }
        });

    }

    private void setUpRightButton(@NonNull View view) {

        ImageView rightArrowButton = view.findViewById(R.id.right_arrow);
        rightArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your code here
                // This code will be executed when the ImageView is clicked
                View rootView = view.getRootView();
                int width = rootView.getWidth();
                ImageView character = view.findViewById(R.id.userCharacter);
                int landing;
                if (getSpriteInt() == 0) {
                    character.setImageResource(R.drawable.blue_right1);
                    landing = R.drawable.blue_right;
                } else if (getSpriteInt() == 1) {
                    character.setImageResource(R.drawable.green_right1);
                    landing = R.drawable.green_right;
                } else {
                    character.setImageResource(R.drawable.yellow_right1);
                    landing = R.drawable.yellow_right;
                }

                if (character.getX() < width - 200) {
                    character.setX(character.getX() + 155);
                }

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        character.setImageResource(landing);
                    }
                }, 200);
            }
        });



    }

    private void setUpLeftButton(@NonNull View view) {

        ImageView leftArrowButton = view.findViewById(R.id.left_arrow);
        leftArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your code here
                // This code will be executed when the ImageView is clicked
                ImageView character = view.findViewById(R.id.userCharacter);
                int landing;
                if (getSpriteInt() == 0) {
                    character.setImageResource(R.drawable.blue_left1);
                    landing = R.drawable.blue_left;
                } else if (getSpriteInt() == 1) {
                    character.setImageResource(R.drawable.green_left1);
                    landing = R.drawable.green_left;
                } else {
                    character.setImageResource(R.drawable.yellow_left1);
                    landing = R.drawable.yellow_left;
                }

                if (character.getX() > 100) {
                    character.setX(character.getX() - 155);
                }

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        character.setImageResource(landing);
                    }
                }, 200);
            }
        });
    }

    private void setUpSprite(View view) {
        // Image changes depdends on user character
        ImageView imageView = view.findViewById(R.id.userCharacter);
        assert getArguments() != null;
        setSpriteInt(getArguments().getInt("spriteInt"));

        // blue = 0, green = 1,yellow = 2;
        int spriteType = getSpriteInt();
        if (spriteInt == 0) {
            imageView.setImageResource(R.drawable.blue_up);
        } else if (spriteInt == 1) {
            imageView.setImageResource(R.drawable.green_up);
        } else {
            imageView.setImageResource(R.drawable.yellow_up);
        }
    }



    public double getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    public int getSpriteInt() {
        return spriteInt;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return name;
    }

    public String getSprite() {
        return sprite;
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public void setSpriteInt(int spriteInt) {
        this.spriteInt = spriteInt;
    }

}