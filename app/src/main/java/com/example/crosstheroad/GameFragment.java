package com.example.crosstheroad;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Timer;
import java.util.TimerTask;

public class GameFragment extends Fragment {
    private ImageView character;
    private double score;
    private int lives;
    private String name;
    private String difficulty;
    private String sprite;
    private int spriteInt;
    private double maxHeight = Double.POSITIVE_INFINITY;
    private final int[] points = {5, 10, 15, 20};
    private int count = 0;

    //variables  for vehicles
    private int screenHeight;
    private int screenWidth;

    private ImageView car1;
    private ImageView car11;
    private ImageView car2;
    private ImageView car21;
    private ImageView car3;
    private ImageView car31;
    private ImageView car32;
    private ImageView car4;
    private ImageView car41;
    private ImageView car5;
    private ImageView car51;

    private Bundle bundle = new Bundle();

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

        //moving vehicles initial setting
        Timer timer = new Timer();
        Handler handler = new Handler();

        car1 = view.findViewById(R.id.car1);
        car11 = view.findViewById(R.id.car1_1);
        car2 = view.findViewById(R.id.car2);
        car21 = view.findViewById(R.id.car2_1);
        car3 = view.findViewById(R.id.car3);
        car31 = view.findViewById(R.id.car3_1);
        car32 = view.findViewById(R.id.car3_2);
        car4 = view.findViewById(R.id.car4);
        car41 = view.findViewById(R.id.car4_1);
        car5 = view.findViewById(R.id.car5);
        car51 = view.findViewById(R.id.car5_1);

        WindowManager wm = getActivity().getWindowManager();
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        character = view.findViewById(R.id.userCharacter);

        //event handler (moving vehicles)
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(() -> changePos(10, -6, -8, 13, -8, character, view));
            }
        }, 0, 40);
    }
    // helper function to change the vehicle's position
    private void changePos(int speed1, int speed2, int speed3, int speed4,
                           int speed5, ImageView character, @NonNull View view) {
        if (car1 != null && car1.getX() > screenWidth) {
            car1.setX(-car1.getWidth());
        }
        if (car11 != null && car11.getX() > screenWidth) {
            car11.setX(-car1.getWidth());
        }
        if (car2 != null && car2.getX() + car2.getWidth() < 0) {
            car2.setX(screenWidth + car2.getWidth());
        }
        if (car21 != null && car21.getX() + car21.getWidth() < 0) {
            car21.setX(screenWidth + car21.getWidth());
        }
        if (car3 != null && car3.getX() + car3.getWidth() < 0) {
            car3.setX(screenWidth + car3.getWidth());
        }
        if (car31 != null && car31.getX() + car31.getWidth() < 0) {
            car31.setX(screenWidth + car3.getWidth());
        }
        if (car32 != null && car32.getX() + car32.getWidth() < 0) {
            car32.setX(screenWidth + car3.getWidth());
        }
        if (car4 != null && car4.getX() > screenWidth) {
            car4.setX(-car4.getWidth());
        }
        if (car41 != null && car41.getX() > screenWidth) {
            car41.setX(-car4.getWidth());
        }
        if (car5 != null && car5.getX() + car5.getWidth() < 0) {
            car5.setX(screenWidth + car5.getWidth());
        }
        if (car51 != null && car51.getX() + car51.getWidth() < 0) {
            car51.setX(screenWidth + car51.getWidth());
        }
        car1.setX(car1.getX() + speed1);
        car11.setX(car11.getX() + speed1);
        car2.setX(car2.getX() + speed2);
        car21.setX(car21.getX() + speed2);
        car3.setX(car3.getX() + speed3);
        car31.setX(car31.getX() + speed3);
        car32.setX(car32.getX() + speed3);
        car4.setX(car4.getX() + speed4);
        car41.setX(car41.getX() + speed4);
        car5.setX(car5.getX() + speed5);
        car51.setX(car51.getX() + speed5);

        if (isCollidingWithCars(character, car1)
                ||
                isCollidingWithCars(character, car11)
                ||
                isCollidingWithCars(character, car2)
                ||
                isCollidingWithCars(character, car21)
                ||
                isCollidingWithCars(character, car3)
                ||
                isCollidingWithCars(character, car31)
                ||
                isCollidingWithCars(character, car32)
                ||
                isCollidingWithCars(character, car4)
                ||
                isCollidingWithCars(character, car41)
                ||
                isCollidingWithCars(character, car5)
                ||
                isCollidingWithCars(character, car51)) {
            // Decrement player lives and reset score and position

            TextView livesValue = view.findViewById(R.id.lives_value);
            if (lives == 0) {
                NavHostFragment.findNavController(GameFragment.this)
                        .navigate(R.id.action_GameFragment_to_EndFragment);
            } else {
                // Respawn the character at the starting position
                ImageView reset = view.findViewById(R.id.startCharacter);
                if (getSpriteInt() == 0) {
                    character.setImageResource(R.drawable.blue_up);
                } else if (getSpriteInt() == 1) {
                    character.setImageResource(R.drawable.green_up);
                } else {
                    character.setImageResource(R.drawable.yellow_up);
                }
                character.setX(reset.getX());
                character.setY(reset.getY());
                setLives(getLives() - 1);
                String livesString = String.valueOf(getLives());
                livesValue.setText(livesString);
                score = 0;
                TextView scoreValue = view.findViewById(R.id.score_value);
                String scoreString = String.valueOf(score);
                scoreValue.setText(scoreString);
                maxHeight = Double.POSITIVE_INFINITY;
            }
        }
    }

    private boolean isCollidingWithCars(ImageView character, ImageView car) {
        Rect characterRect = new Rect();
        character.getHitRect(characterRect);

        Rect carRect = new Rect();
        car.getHitRect(carRect);

        return characterRect.intersect(carRect);
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
        upArrowButton.setOnClickListener(v -> {
            // Your code here
            // This code will be executed when the ImageView is clicked

            character = view.findViewById(R.id.userCharacter);
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
                character.setY(character.getY() - 160);
                isWater(view);
                new Handler().postDelayed(() -> {
                    character.setImageResource(landing);
                    if (character.getY() < 300) {
                        ImageView reset = view.findViewById(R.id.startCharacter);
                        character.setX(reset.getX());
                        character.setY(reset.getY());
                        maxHeight = Double.POSITIVE_INFINITY;
                    }
                }, 200);
                if (character.getY() < 300) {
                    if (character.getX() >= goal1.getX()
                            && character.getX() + character.getWidth()
                            <= goal1.getX() + goalWidth) {
                        goal1.setImageResource(R.drawable.catched_frog);
                    } else if (character.getX() >= goal2.getX()
                            && character.getX() + character.getWidth()
                            <= goal2.getX() + goalWidth) {
                        goal2.setImageResource(R.drawable.catched_frog);
                    } else if (character.getX() >= goal3.getX()
                            && character.getX() + character.getWidth()
                            <= goal3.getX() + goalWidth) {
                        goal3.setImageResource(R.drawable.catched_frog);
                    } else if (character.getX() >= goal4.getX()
                            && character.getX() + character.getWidth()
                            <= goal4.getX() + goalWidth) {
                        goal4.setImageResource(R.drawable.catched_frog);
                    } else if (character.getX() >= goal5.getX()
                            && character.getX() + character.getWidth()
                            <= goal5.getX() + goalWidth) {
                        goal5.setImageResource(R.drawable.catched_frog);
                    } else {
                        TextView livesValue = view.findViewById(R.id.lives_value);
                        setLives(getArguments().getInt("lives") - (++count));
                        String livesString = String.valueOf(getLives());
                        livesValue.setText(livesString);

                    }
                }
            }
        });
    }

    private void setUpDownButton(@NonNull View view) {

        ImageView bottomArrowButton = view.findViewById(R.id.bottom_arrow);
        bottomArrowButton.setOnClickListener(v -> {
            // Your code here
            // This code will be executed when the ImageView is clicked
            View rootView = view.getRootView();
            ImageView startCharacter = view.findViewById(R.id.startCharacter);
            int startPoint = (int) startCharacter.getY();
            character = view.findViewById(R.id.userCharacter);
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

            if (character.getY() < startPoint) {
                character.setY(character.getY() + 160);
                isWater(view);
            }

            new Handler().postDelayed(() -> character.setImageResource(landing), 200);
        });

    }

    private void setUpRightButton(@NonNull View view) {
        ImageView rightArrowButton = view.findViewById(R.id.right_arrow);
        rightArrowButton.setOnClickListener(v -> {
            // Your code here
            // This code will be executed when the ImageView is clicked
            View rootView = view.getRootView();
            int width = rootView.getWidth();
            character = view.findViewById(R.id.userCharacter);
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
                character.setX(character.getX() + 100);
                isWater(view);
            }

            new Handler().postDelayed(() -> character.setImageResource(landing), 200);
        });
    }

    private void setUpLeftButton(@NonNull View view) {
        ImageView leftArrowButton = view.findViewById(R.id.left_arrow);
        leftArrowButton.setOnClickListener(v -> {
            // Your code here
            // This code will be executed when the ImageView is clicked
            character = view.findViewById(R.id.userCharacter);
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
                character.setX(character.getX() - 100);
                isWater(view);
            }

            new Handler().postDelayed(() -> character.setImageResource(landing), 200);
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
    private void isWater(@NonNull View view) {
        ImageView character = getView().findViewById(R.id.userCharacter);
        ImageView startCharacter = getView().findViewById(R.id.startCharacter);
        float characterX = character.getX();
        float characterY = character.getY();
        float startPointY = startCharacter.getY();

        if ((0 < characterX && characterX < screenWidth)
                && (100 < characterY && characterY < startPointY / 2)) {
            character.setX(startCharacter.getX());
            character.setY(startCharacter.getY());
            TextView livesValue = getView().findViewById(R.id.lives_value);
            livesValue.setText(String.valueOf(--lives));
            maxHeight = Double.POSITIVE_INFINITY;
            score = 0;
            TextView scoreValue = view.findViewById(R.id.score_value);
            String scoreString = String.valueOf(score);
            scoreValue.setText(scoreString);
            if (lives == 0) {
                NavHostFragment.findNavController(GameFragment.this)
                        .navigate(R.id.action_GameFragment_to_EndFragment);

                // Pass score to the EndFragment
                bundle.putDouble("user_endscore", score);
            }
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

    public void setCharacter(ImageView character) {
        this.character = character;
    }

    public ImageView getCharacter() {
        return character;
    }
}