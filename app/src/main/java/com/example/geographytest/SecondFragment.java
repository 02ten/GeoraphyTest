package com.example.geographytest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.geographytest.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Game game = new Game();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        game.setConditions(binding);
        super.onViewCreated(view, savedInstanceState);
        CountDownTimer timer = createTimer();
        timer.start();
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game.checkAnswer(binding)) {
                    FirstFragment.user.setScore(FirstFragment.user.getScore() + 1);
                }
                FirstFragment.user.setAnsweredQuestions(FirstFragment.user.getAnsweredQuestions() + 1);
                if (FirstFragment.user.getAnsweredQuestions() == Game.totalQuestions) {
                    timer.cancel();
                    changeFragment();
                } else
                    game.setConditions(binding);
            }
        });
    }

    private CountDownTimer createTimer() {
        CountDownTimer timer = new CountDownTimer(1200000, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                if(l / 60000 < 10 && l % 60000 / 1000 < 10)
                    binding.timer.setText("0"+(l / 60000)+ ":0" + (l % 60000 / 1000));
                else if(l / 60000 > 10 && l % 60000 / 1000 < 10)
                    binding.timer.setText((l / 60000)+ ":0" + (l % 60000 / 1000));
                else if(l / 60000 < 10 && l % 60000 / 1000 > 10)
                    binding.timer.setText("0"+(l / 60000)+ ":" + (l % 60000 / 1000));
                else
                    binding.timer.setText((l / 60000)+ ":" + (l % 60000 / 1000));
            }

            @Override
            public void onFinish() {
                changeFragment();
            }
        };
        return timer;

    }

    private void changeFragment() {
        game.getPreviousIndexes().clear();
        NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_ThirdFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}