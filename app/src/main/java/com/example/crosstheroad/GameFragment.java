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

import java.util.Arrays;
import java.util.List;
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
    private int goalCount = 0;

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
    private ImageView log1;
    private ImageView log2;
    private ImageView log3;
    private ImageView log4;
    private ImageView log5;
    private ImageView goal5;
    private ImageView goal4;
    private ImageView goal3;
    private ImageView goal2;
    private ImageView goal1;

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
        log1 = view.findViewById(R.id.log1);
        log2 = view.findViewById(R.id.log2);
        log3 = view.findViewById(R.id.log3);
        log4 = view.findViewById(R.id.log4);
        log5 = view.findViewById(R.id.log5);

        Point screenSize = getScreenSize();
        screenWidth = screenSize.x;
        screenHeight = screenSize.y;
        character = view.findViewById(R.id.userCharacter);

        //event handler (moving vehicles)
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(() -> changePos(5, -3, -4, 6, -2, character, view));
            }
        }, 0, 40);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int[] speedList = new int[] {3, -3, -2, 2};
                handler.post(() -> checkLogs(speedList, character, view));
            }
        }, 0, 40);
    }

    private Point getScreenSize() {
        WindowManager wm = getActivity().getWindowManager();
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    private void checkLogs(int[] speedList, ImageView character, @NonNull View view) {
        List<ImageView> logs = Arrays.asList(log1, log2, log3);
        if (log1 != null && log1.getX() > screenWidth) {
            log1.setX(-log1.getWidth());
        }
        if (log2 != null && log2.getX() + log2.getWidth() < 0) {
            log2.setX(screenWidth + log2.getWidth());
        }
        if (log3 != null && log3.getX() > screenWidth) {
            log3.setX(-log3.getWidth());
        }
        if (log4 != null && log4.getX() + log4.getWidth() < 0) {
            log4.setX(screenWidth + log4.getWidth());
        }
        if (log5 != null && log5.getX() > screenWidth) {
            log5.setX(-log5.getWidth());
        }
        log1.setX(log1.getX() + speedList[0]);
        log2.setX(log2.getX() + speedList[1]);
        log4.setX(log4.getX() + speedList[2]);
        log5.setX(log5.getX() + speedList[3]);
        ImageView liver5 = view.findViewById(R.id.river5);
        ImageView liver4 = view.findViewById(R.id.river4);
        ImageView liver3 = view.findViewById(R.id.river3);
        ImageView liver2 = view.findViewById(R.id.river2);
        ImageView liver1 = view.findViewById(R.id.river1);


        if (isIntersectWithLogs(character, log1, liver5)) {
            character.setX(character.getX() + speedList[0]);
        }

        if (isIntersectWithLogs(character, log2, liver4)) {
            character.setX(character.getX() + speedList[1]);
        }
        if (isIntersectWithLogs(character, log4, liver2)) {
            character.setX(character.getX() + speedList[2]);
        }
        if (isIntersectWithLogs(character, log5, liver1)) {
            character.setX(character.getX() + speedList[3]);
        }
    }

    private boolean isIntersectWithLogs(ImageView character, ImageView log, ImageView liver) {
        return character.getX() >= log.getX() && (character.getX() + character.getWidth())
                <= (log.getX() + log.getWidth()) && character.getY() >= liver.getY()
                && (character.getY() + character.getHeight()) <= (liver.getY() + liver.getHeight());
    }


    // helper function to change the vehicle's position
    private void changePos(int speed1, int speed2, int speed3, int speed4,
                           int speed5, ImageView character, @NonNull View view) {
        List<ImageView> cars = Arrays.asList(car1, car11, car2,
                car21, car3, car31, car32, car4, car41, car5, car51);
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
        View rootView = view.getRootView();
        int width = rootView.getWidth();
        if (isCollidingWithAnyCar(character, cars) || character.getX() <= 0
                || character.getX() + character.getWidth() >= width) {
            // Decrement player lives and reset score and position

            TextView livesValue = view.findViewById(R.id.lives_value);
            if (lives <= 0) {
                gameDone();
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
                goalCount = 0;
                goal1.setImageResource(R.drawable.frog_dead);
                goal2.setImageResource(R.drawable.frog_dead);
                goal3.setImageResource(R.drawable.frog_dead);
                goal4.setImageResource(R.drawable.frog_dead);
                goal5.setImageResource(R.drawable.frog_dead);
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

    private boolean isCollidingWithAnyCar(ImageView character, List<ImageView> cars) {
        for (ImageView car : cars) {
            if (isCollidingWithCars(character, car)) {
                return true;
            }
        }
        return false;
    }

    private void isWater(@NonNull View view) {
        ImageView character = getView().findViewById(R.id.userCharacter);
        ImageView startCharacter = getView().findViewById(R.id.startCharacter);
        ImageView liver5 = getView().findViewById(R.id.river5);
        ImageView liver4 = getView().findViewById(R.id.river4);
        ImageView liver3 = getView().findViewById(R.id.river3);
        ImageView liver2 = getView().findViewById(R.id.river2);
        ImageView liver1 = getView().findViewById(R.id.river1);
        Rect characterRect = new Rect();
        character.getHitRect(characterRect);
        Rect liver5Rect = new Rect();
        liver5.getHitRect(liver5Rect);

        Rect liver4Rect = new Rect();
        liver4.getHitRect(liver4Rect);

        Rect liver3Rect = new Rect();
        liver3.getHitRect(liver3Rect);

        Rect liver2Rect = new Rect();
        liver2.getHitRect(liver2Rect);

        Rect liver1Rect = new Rect();
        liver1.getHitRect(liver1Rect);
        View rootView = view.getRootView();
        int width = rootView.getWidth();

        if ((characterRect.intersect(liver5Rect) && !isIntersectWithLogs(character, log1, liver5))
                || (characterRect.intersect(liver4Rect)
                && !isIntersectWithLogs(character, log2, liver4))
                || (characterRect.intersect(liver3Rect)
                && !isIntersectWithLogs(character, log3, liver3))
                || (characterRect.intersect(liver2Rect)
                && !isIntersectWithLogs(character, log4, liver2))
                || (characterRect.intersect(liver1Rect)
                && !isIntersectWithLogs(character, log5, liver1))
                || character.getX() <= 0
                || character.getX() + character.getWidth() >= width) {
            character.setX(startCharacter.getX());
            character.setY(startCharacter.getY());
            TextView livesValue = getView().findViewById(R.id.lives_value);
            livesValue.setText(String.valueOf(--lives));
            maxHeight = Double.POSITIVE_INFINITY;
            score = 0;
            goalCount = 0;
            goal1.setImageResource(R.drawable.frog_dead);
            goal2.setImageResource(R.drawable.frog_dead);
            goal3.setImageResource(R.drawable.frog_dead);
            goal4.setImageResource(R.drawable.frog_dead);
            goal5.setImageResource(R.drawable.frog_dead);
            TextView scoreValue = view.findViewById(R.id.score_value);
            String scoreString = String.valueOf(score);
            scoreValue.setText(scoreString);
            if (lives <= 0) {
                gameDone();
            }
        }
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
        Point screenSize = getScreenSize();
        screenWidth = screenSize.x;
        screenHeight = screenSize.y;
        upArrowButton.setOnClickListener(v -> {
            // Your code here
            // This code will be executed when the ImageView is clicked

            character = view.findViewById(R.id.userCharacter);
            goal1 = view.findViewById(R.id.goal_1);
            goal2 = view.findViewById(R.id.goal_2);
            goal3 = view.findViewById(R.id.goal_3);
            goal4 = view.findViewById(R.id.goal_4);
            goal5 = view.findViewById(R.id.goal_5);
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

            if (character.getY() > screenHeight / 7) {
                if (maxHeight > character.getY()) {
                    maxHeight = character.getY();
                    score += points[(int) maxHeight % 4];
                    TextView scoreValue = view.findViewById(R.id.score_value);
                    String scoreString = String.valueOf(score);
                    scoreValue.setText(scoreString);
                }
                character.setY(character.getY() - view.findViewById(R.id.road1).getHeight());
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
                if (character.getY() < screenHeight / 7) {
                    if (character.getX() >= goal1.getX()
                            && character.getX() + character.getWidth()
                            <= goal1.getX() + goalWidth) {
                        goal1.setImageResource(R.drawable.catched_frog);
                        goalCount++;
                        score += 1000;
                        TextView scoreValue = view.findViewById(R.id.score_value);
                        String scoreString = String.valueOf(score);
                        scoreValue.setText(scoreString);
                        if (goalCount >= 5) {
                            gameDone();
                        }
                    } else if (character.getX() >= goal2.getX()
                            && character.getX() + character.getWidth()
                            <= goal2.getX() + goalWidth) {
                        goal2.setImageResource(R.drawable.catched_frog);
                        goalCount++;
                        score += 1000;
                        TextView scoreValue = view.findViewById(R.id.score_value);
                        String scoreString = String.valueOf(score);
                        scoreValue.setText(scoreString);
                        if (goalCount >= 5) {
                            gameDone();
                        }
                    } else if (character.getX() >= goal3.getX()
                            && character.getX() + character.getWidth()
                            <= goal3.getX() + goalWidth) {
                        goal3.setImageResource(R.drawable.catched_frog);
                        goalCount++;
                        score += 1000;
                        TextView scoreValue = view.findViewById(R.id.score_value);
                        String scoreString = String.valueOf(score);
                        scoreValue.setText(scoreString);
                        if (goalCount >= 5) {
                            gameDone();
                        }
                    } else if (character.getX() >= goal4.getX()
                            && character.getX() + character.getWidth()
                            <= goal4.getX() + goalWidth) {
                        goal4.setImageResource(R.drawable.catched_frog);
                        goalCount++;
                        score += 1000;
                        TextView scoreValue = view.findViewById(R.id.score_value);
                        String scoreString = String.valueOf(score);
                        scoreValue.setText(scoreString);
                        if (goalCount >= 5) {
                            gameDone();
                        }
                    } else if (character.getX() >= goal5.getX()
                            && character.getX() + character.getWidth()
                            <= goal5.getX() + goalWidth) {
                        goal5.setImageResource(R.drawable.catched_frog);
                        goalCount++;
                        score += 1000;
                        TextView scoreValue = view.findViewById(R.id.score_value);
                        String scoreString = String.valueOf(score);
                        scoreValue.setText(scoreString);
                        if (goalCount >= 5) {
                            gameDone();
                        }
                    } else {
                        if (lives <= 0) {
                            gameDone();
                        } else {
                            respawn(view);
                            if (lives <= 0) {
                                gameDone();
                            }
                        }
                    }
                }
            }
        });
    }
    private void respawn(View view) {
        ImageView startCharacter = getView().findViewById(R.id.startCharacter);
        character.setX(startCharacter.getX());
        character.setY(startCharacter.getY());
        TextView livesValue = getView().findViewById(R.id.lives_value);
        livesValue.setText(String.valueOf(--lives));
        maxHeight = Double.POSITIVE_INFINITY;
        score = 0;
        goalCount = 0;
        goal1.setImageResource(R.drawable.frog_dead);
        goal2.setImageResource(R.drawable.frog_dead);
        goal3.setImageResource(R.drawable.frog_dead);
        goal4.setImageResource(R.drawable.frog_dead);
        goal5.setImageResource(R.drawable.frog_dead);
        TextView scoreValue = view.findViewById(R.id.score_value);
        String scoreString = String.valueOf(score);
        scoreValue.setText(scoreString);
    }
    private void setUpDownButton(@NonNull View view) {
        ImageView bottomArrowButton = view.findViewById(R.id.bottom_arrow);
        Point screenSize = getScreenSize();
        screenWidth = screenSize.x;
        screenHeight = screenSize.y;

        bottomArrowButton.setOnClickListener(v -> {
            character = view.findViewById(R.id.userCharacter);
            int landing = updateCharacterSpriteForDown();

            ImageView startCharacter = view.findViewById(R.id.startCharacter);
            int startPoint = (int) startCharacter.getY();

            if (character.getY() < startPoint) {
                character.setY(character.getY() + view.findViewById(R.id.road1).getHeight());
                isWater(view);
            }

            new Handler().postDelayed(() -> character.setImageResource(landing), 200);
        });
    }

    private int updateCharacterSpriteForDown() {
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
        return landing;
    }

    private void setUpRightButton(@NonNull View view) {
        ImageView rightArrowButton = view.findViewById(R.id.right_arrow);
        Point screenSize = getScreenSize();
        screenWidth = screenSize.x;
        screenHeight = screenSize.y;

        rightArrowButton.setOnClickListener(v -> {
            character = view.findViewById(R.id.userCharacter);
            int landing = updateCharacterSpriteForRight();

            int rootViewWidth = view.getRootView().getWidth();
            int moveThreshold = rootViewWidth - rootViewWidth / 5;

            if (character.getX() < moveThreshold) {
                character.setX(character.getX() + rootViewWidth / 10);
                isWater(view);
            }

            new Handler().postDelayed(() -> character.setImageResource(landing), 200);
        });
    }

    private int updateCharacterSpriteForRight() {
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
        return landing;
    }

    private void setUpLeftButton(@NonNull View view) {
        ImageView leftArrowButton = view.findViewById(R.id.left_arrow);
        Point screenSize = getScreenSize();
        screenWidth = screenSize.x;
        screenHeight = screenSize.y;

        leftArrowButton.setOnClickListener(v -> {
            character = view.findViewById(R.id.userCharacter);
            int landing = updateCharacterSpriteForLeft();

            int rootViewWidth = view.getRootView().getWidth();
            int moveThreshold = 100;

            if (character.getX() > moveThreshold) {
                character.setX(character.getX() - rootViewWidth / 10);
                isWater(view);
            }

            new Handler().postDelayed(() -> character.setImageResource(landing), 200);
        });
    }

    private int updateCharacterSpriteForLeft() {
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
        return landing;
    }

    private void gameDone() {
        // Pass score to the other fragments
        bundle.putDouble("user_endscore", score);

        if (lives <= 0) {
            NavHostFragment.findNavController(GameFragment.this)
                    .navigate(R.id.action_GameFragment_to_EndFragment, bundle);
        } else {
            NavHostFragment.findNavController(GameFragment.this)
                    .navigate(R.id.action_GameFragment_to_WinFragment, bundle);
        }
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

    public void setCharacter(ImageView character) {
        this.character = character;
    }

    public ImageView getCharacter() {
        return character;
    }
}