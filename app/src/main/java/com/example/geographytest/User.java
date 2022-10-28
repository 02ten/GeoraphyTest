package com.example.geographytest;

public class User {
    private String name;
    private String group;
    private int score = 0;
    private int answeredQuestions = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(int answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
