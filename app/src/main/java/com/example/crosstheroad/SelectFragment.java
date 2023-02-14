package com.example.crosstheroad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.crosstheroad.databinding.FragmentSelectBinding;

public class SelectFragment extends Fragment {

    private FragmentSelectBinding binding;
    private String sprite;
    private String name;
    private int lives;
    private String difficulty;



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
                binding.frog.setImageResource(R.drawable.selected_frog);
                binding.dog.setImageResource(R.drawable.dog);
                binding.cat.setImageResource(R.drawable.cat);



            }
        });
        binding.dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.frog.setImageResource(R.drawable.frog);
                binding.dog.setImageResource(R.drawable.selected_dog);
                binding.cat.setImageResource(R.drawable.cat);
            }
        });
        binding.cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.frog.setImageResource(R.drawable.frog);
                binding.dog.setImageResource(R.drawable.dog);
                binding.cat.setImageResource(R.drawable.selected_cat);

            }
        });
        binding.buttonEasy.setOnClickListener(view1 -> {lives = 3;
            difficulty = "Easy";});

        binding.buttonNormal.setOnClickListener(view1 -> {lives = 5;
            difficulty = "Normal";
        });
        binding.buttonHard.setOnClickListener(view1 -> {lives = 7;
            difficulty = "Hard";
        });
        name = binding.Name.getText().toString();
        binding.buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name != null && !name.equals(" ")) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("lives", lives);
                    bundle.putString("name", name);
                    bundle.putString("difficulty", difficulty);
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