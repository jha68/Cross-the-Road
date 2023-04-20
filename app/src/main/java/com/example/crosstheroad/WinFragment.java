package com.example.crosstheroad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.crosstheroad.databinding.FragmentWinBinding;

public class WinFragment extends Fragment {

    private @NonNull FragmentWinBinding binding;
    private double finalScore;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWinBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView scoreDisplay = view.findViewById(R.id.finalScore_num);
        setScore(getArguments().getDouble("user_endscore"));
        String scoreString = String.valueOf(getScore());
        scoreDisplay.setText(scoreString);

        // Set up OnClickListener for the restart button
        binding.restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the SelectFragment
                NavHostFragment.findNavController(WinFragment.this)
                        .navigate(R.id.action_winFragment_to_SelectFragment);
            }
        });

        // Set up OnClickListener for the exit button
        binding.endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Exit the app
                requireActivity().finish();
            }
        });
    }
    private void setUpFinalScore(@NonNull View view) {
        TextView scoreDisplay = view.findViewById(R.id.finalScore_num);
        setScore(getArguments().getDouble("user_endscore"));
        String scoreString = String.valueOf(getScore());
        scoreDisplay.setText(scoreString);
    }
    public double getScore() {
        return finalScore; }

    public void setScore(double finalScore) {
        this.finalScore = finalScore; }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}