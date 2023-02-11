package com.example.crosstheroad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        binding.buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lives = 7;
                Snackbar snackbar = Snackbar
                        .make(view, "You have selected Easy", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        binding.buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lives = 5;
                Snackbar snackbar = Snackbar
                        .make(view, "You have selected Normal", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        binding.buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lives = 3;
                Snackbar snackbar = Snackbar
                        .make(view, "You have selected Hard", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        binding.frog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(view, "You have selected a Frog", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        binding.cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(view, "You have selected a Cat", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        binding.dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(view, "You have selected a Dog", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}