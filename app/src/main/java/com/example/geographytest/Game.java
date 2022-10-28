package com.example.geographytest;


import android.view.View;
import android.widget.RadioButton;

import com.example.geographytest.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private String[] questions = new String[]
            {
                    "Какой именно пролив отделяет Гренландию от Исландии?",//0
                    "Столица Турции - это ....",//1
                    "Столица Румынии - это ...",//2
                    "Столица Финляндии - это ....",//3
                    "Столица Сирии - это ....",//4
                    "Какой из нижеперечисленных городов находится на побережье Атлантического океана?",//5
                    "Какая именно гора является самой высокой точкой на африканском континенте?",//6
                    "Столица Узбекистана - это ....",//7
                    "Столица Южной Кореи - это ....",//8
                    "Как называется валюта Болгарии?",//9
                    "В каком городе мира живёт больше всего людей?"//10
            };
    private String[][] answers = new String[][]
            {
                    {"Датский пролив", "Девисов пролив", "Пролив Дрейка", "asdf"},//0
                    {"Стамбул", "Анкара", "asdf", "Анталья"},//1
                    {"Брашов", "Бухарест", "Тимишоара", "asdf"},//2
                    {"Лаппеенранта", "Порвоо", "Хельсинки", "asdf"},//3
                    {"Алеппо", "Ракка", "Дамаск", "asdf"},//4
                    {"Гуанчжоу", "Кейптаун", "Сидней", "asdf"},//5
                    {"asdf", "Стэнли", "Мавензи", "Килиманджаро"},//6
                    {"Самарканд", "Ташкент", "Бухара", "asdf"},//7
                    {"Пусан", "Сеул", "Инчхон", "asdf"},//8
                    {"Лат", "Лев", "Лит", "Евро"},//9
                    {"Токио", "Дели", "Шанхай", "Пекин"}//10
            };
    private int[] correctAnswer = new int[]{
            2,//0
            1,//1
            1,//2
            2,//3
            2,//4
            1,//5
            3,//6
            1,//7
            1,//8
            1,//9
            2//10
    };

    public static final int totalQuestions = 5;
    private List<Integer> previousIndexes = new ArrayList<>();

    public void setConditions(FragmentSecondBinding fragmentSecondBinding){
        int randomIndex = generateRandomIndex();
        setQuestion(fragmentSecondBinding, randomIndex);
        setAnswers(fragmentSecondBinding, randomIndex);
    }

    private void setQuestion(FragmentSecondBinding binding, int randomIndex){
        binding.question.setText(questions[randomIndex]);
    }

    private void setAnswers(FragmentSecondBinding binding, int randomIndex){
        binding.answer.setText(answers[randomIndex][0]);
        binding.answer1.setText(answers[randomIndex][1]);
        binding.answer2.setText(answers[randomIndex][2]);
        binding.answer3.setText(answers[randomIndex][3]);
    }

    public boolean checkAnswer(FragmentSecondBinding binding){
        int checkedIdRadioButton = binding.radioGroup.getCheckedRadioButtonId();
        int x = 0;
        switch (checkedIdRadioButton){
            case R.id.radioButton: x = 0; break;
            case R.id.radioButton1: x = 1; break;
            case R.id.radioButton2: x = 2; break;
            case R.id.radioButton3: x = 3; break;
        }
        binding.radioGroup.clearCheck();
        System.out.println(x+ " " + correctAnswer[previousIndexes.size()-1] + " " + (previousIndexes.size()-1));
        if(x == correctAnswer[previousIndexes.get(previousIndexes.size()-1)])
            return true;
        return false;
    }

    private int generateRandomIndex(){
        int randomIndex = (int) (Math.random()* answers.length);
        while(previousIndexes.contains(randomIndex)){
            randomIndex = (int) (Math.random()* answers.length);
        }
        previousIndexes.add(randomIndex);
        return randomIndex;
    }

    public List<Integer> getPreviousIndexes(){
        return previousIndexes;
    }
}
