package com.example.crosstheroad;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.app.Activity;

import com.example.crosstheroad.databinding.FragmentSelectBinding;

public class SelectFragment extends Fragment {

    private FragmentSelectBinding binding;
    private String sprite;
    private String name;
    private int lives;

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
        binding.buttonEasy.setOnClickListener(view1 -> lives = 7);
        binding.buttonNormal.setOnClickListener(view1 -> lives = 5);
        binding.buttonHard.setOnClickListener(view1 -> lives = 3);
        binding.buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = requireContext().getString(R.id.Name);
                if (name != null && !name.equals(" ")) {
                    NavHostFragment.findNavController(SelectFragment.this)
                            .navigate(R.id.action_SelectFragment_to_gameFragment);
                }
            }
        });
    }

    public String getName() {
        return name;
    }
    public int getLives() {
        return lives;
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