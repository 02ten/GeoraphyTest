package com.example.geographytest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.geographytest.databinding.FragmentSecondBinding;
import com.example.geographytest.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        int score = FirstFragment.user.getScore();
        String name = FirstFragment.user.getName();
        float percent = (float) score / (float) Game.totalQuestions * 100;
        binding.result.setText(name + ", вы набрали: " + score + " из " + Game.totalQuestions +
                ". Это "+ percent + "%");
        binding.tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragment.user.setScore(0);
                FirstFragment.user.setAnsweredQuestions(0);
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);


            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}