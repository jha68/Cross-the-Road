package com.example.crosstheroad;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.crosstheroad.databinding.FragmentSelectBinding;

public class SelectFragment extends Fragment {

    private FragmentSelectBinding binding;
    private String sprite;
    private String name;
    private int lives;
    private int spriteInt;
    private String difficulty;

    // frog = 0, dog = 1,cat = 2;


    Fragment fragment = new Fragment();
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

        binding.frog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When frog is selected
                binding.frog.setImageResource(R.drawable.selected_frog);
                binding.dog.setImageResource(R.drawable.dog);
                binding.cat.setImageResource(R.drawable.cat);
                sprite = "frog";
                spriteInt = 0;
            }
        });
        binding.dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when dog is selected
                binding.frog.setImageResource(R.drawable.frog);
                binding.dog.setImageResource(R.drawable.selected_dog);
                binding.cat.setImageResource(R.drawable.cat);
                sprite = "dog";
                spriteInt = 1;
            }
        });
        binding.cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When cat is selected
                binding.frog.setImageResource(R.drawable.frog);
                binding.dog.setImageResource(R.drawable.dog);
                binding.cat.setImageResource(R.drawable.selected_cat);
                sprite = "cat";
                spriteInt = 2;
            }
        });

        // Difficulty with the number of life
        binding.buttonEasy.setOnClickListener(view1 -> {lives = 3;
            difficulty = "Easy";});

        binding.buttonNormal.setOnClickListener(view1 -> {lives = 5;
            difficulty = "Normal";
        });
        binding.buttonHard.setOnClickListener(view1 -> {lives = 7;
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