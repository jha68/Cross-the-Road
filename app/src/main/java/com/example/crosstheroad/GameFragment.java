package com.example.crosstheroad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {

    private double score;
    private int lives;
    private String name;
    private String difficulty;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        score = 00000;
        lives = 0;
        name = "asdf";
        difficulty = "difficulty";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView livesValue = view.findViewById(R.id.lives_value);
        lives = getArguments().getInt("lives");
        String lives_string =String.valueOf(lives);
        livesValue.setText(lives_string);



        TextView nameValue = view.findViewById(R.id.name_value);
        name = getArguments().getString("name");
        nameValue.setText(name);


        TextView difficultyValue = view.findViewById(R.id.difficulty_value);
        difficulty = getArguments().getString("difficulty");
        difficultyValue.setText(difficulty);
    }

}