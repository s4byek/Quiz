package com.example.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStatsDTO {
    private Long userId;
    private String username;
    private int rating;
    private int experience;
    private int level;
    private int totalAnswers;
    private int correctAnswers;
    private double accuracy;
}

