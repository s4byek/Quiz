package com.example.quiz.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResultDTO {
    private boolean correct;
    private int pointsEarned;
    private int experienceGained;
    private int newRating;
    private int newExperience;
    private int newLevel;
    private String correctAnswerText;
}