package com.example.crosstheroad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.crosstheroad.databinding.FragmentEndBinding;

public class EndFragment extends Fragment {

    private FragmentEndBinding binding;

    private double finalScore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finalScore = 0;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEndBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Display final score
        /*  TextView scoreDisplay = view.findViewById(R.id.finalScore);
        setScore(getArguments().getDouble("user_endscore"));
        String scoreString = String.valueOf(getScore());
        scoreDisplay.setText(scoreString); */

        // setUpFinalScore(view); Activated needed after game complete


        // Set up OnClickListener for the restart button
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the SelectFragment
                NavHostFragment.findNavController(EndFragment.this)
                        .navigate(R.id.action_endFragment_to_SelectFragment);
            }
        });

        // Set up OnClickListener for the exit button
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Exit the app
                requireActivity().finish();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setUpFinalScore(@NonNull View view) {
        TextView scoreDisplay = view.findViewById(R.id.finalScore);
        setScore(getArguments().getDouble("user_endscore"));
        String scoreString = String.valueOf(getScore());
        scoreDisplay.setText(scoreString);
    }

    public double getScore() {
        return finalScore; }

    public void setScore(double finalScore) {
        this.finalScore = finalScore; }
}