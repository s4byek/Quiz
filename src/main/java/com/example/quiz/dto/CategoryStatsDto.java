package com.example.quiz.dto;

import com.example.quiz.model.Category;

public class CategoryStatsDto {
    private final Category category;
    private final long totalAnswers;
    private final long correctAnswers;
    private final double avgRatingChange;

    public CategoryStatsDto(Category category,
                            long totalAnswers,
                            long correctAnswers,
                            double avgRatingChange) {
        this.category = category;
        this.totalAnswers = totalAnswers;
        this.correctAnswers = correctAnswers;
        this.avgRatingChange = avgRatingChange;
    }

    public Category getCategory() {
        return category;
    }

    public long getTotalAnswers() {
        return totalAnswers;
    }

    public long getCorrectAnswers() {
        return correctAnswers;
    }

    public double getAvgRatingChange() {
        return avgRatingChange;
    }

    public double getAccuracy() {
        if (totalAnswers == 0) {
            return 0.0;
        }
        return (correctAnswers * 100.0) / totalAnswers;
    }
}
