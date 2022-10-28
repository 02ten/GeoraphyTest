package com.example.geographytest;

import android.os.Bundle;
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

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(game.checkAnswer(binding));
                if(game.checkAnswer(binding))
                    FirstFragment.user.setScore(FirstFragment.user.getScore()+1);
                FirstFragment.user.setAnsweredQuestions(FirstFragment.user.getAnsweredQuestions()+1);
                if(FirstFragment.user.getAnsweredQuestions() == Game.totalQuestions){
                    game.getPreviousIndexes().clear();

                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_ThirdFragment);
                }

                else
                    game.setConditions(binding);


            }
        });
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}