package com.example.quiz.model;

public enum Difficulty {
    EASY(10, 20, 10),
    MEDIUM(20, 50, 25),
    HARD(35, 100, 50);

    private final int stake;
    private final int reward;
    private final int experience;

    Difficulty(int stake, int reward, int experience) {
        this.stake = stake;
        this.reward = reward;
        this.experience = experience;
    }

    public int getStake() {
        return stake;
    }

    public int getReward() {
        return reward;
    }

    public int getExperience() {
        return experience;
    }

    public int getNetProfit() {
        return reward - stake;
    }
}