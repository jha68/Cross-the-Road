package com.example.crosstheroad;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.crosstheroad.databinding.FragmentSelectBinding;
import com.google.android.material.snackbar.Snackbar;

public class SelectFragment extends Fragment {

    private FragmentSelectBinding binding;
    private String sprite;
    private String name;
    private int lives;
    private int spriteInt;
    private String difficulty;

    // frog = 0, dog = 1,cat = 2;


    private Fragment fragment = new Fragment();
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSelectBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.blueFrog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When frog is selected
                binding.blueFrog.setImageResource(R.drawable.blue_frog1);
                binding.greenFrog.setImageResource(R.drawable.green_frog);
                binding.yellowFrog.setImageResource(R.drawable.yellow_frog);
                sprite = "blue_frog";
                spriteInt = 0;
            }
        });
        binding.greenFrog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when dog is selected
                binding.blueFrog.setImageResource(R.drawable.blue_frog);
                binding.greenFrog.setImageResource(R.drawable.green_frog1);
                binding.yellowFrog.setImageResource(R.drawable.yellow_frog);
                sprite = "green_frog";
                spriteInt = 1;
            }
        });
        binding.yellowFrog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When yellowFrog is selected
                binding.blueFrog.setImageResource(R.drawable.blue_frog);
                binding.greenFrog.setImageResource(R.drawable.green_frog);
                binding.yellowFrog.setImageResource(R.drawable.yellow_frog1);
                sprite = "yellow_frog";
                spriteInt = 2;
            }
        });

        // Difficulty with the number of life
        binding.buttonEasy.setOnClickListener(view1 -> {
            lives = 7;
            difficulty = "Easy";
        });

        binding.buttonNormal.setOnClickListener(view1 -> {
            lives = 5;
            difficulty = "Normal";
        });
        binding.buttonHard.setOnClickListener(view1 -> {
            lives = 3;
            difficulty = "Hard";
        });

        // Get the user input
        EditText nameInput = (EditText) view.findViewById(R.id.Name);

        binding.buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameInput.getText().toString();

                if (name == null || name.trim().length() == 0) {
                    String message = "Check the name";
                    Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                } else if (difficulty == null) {
                    String message = "Check the difficulty";
                    Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                } else if (sprite == null) {
                    String message = "Check the character";
                    Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("lives", lives);
                    bundle.putString("name", name);
                    bundle.putString("difficulty", difficulty);
                    bundle.putString("sprite", sprite);
                    bundle.putInt("spriteInt", spriteInt);
                    NavHostFragment.findNavController(SelectFragment.this)
                            .navigate(R.id.action_SelectFragment_to_gameFragment,bundle);
                }
            }
        });
    }

    public String getName() {
        return name;
    }

    public String getSprite() {
        return sprite;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}