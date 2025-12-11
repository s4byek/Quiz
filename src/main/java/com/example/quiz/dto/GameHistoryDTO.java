package com.example.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameHistoryDTO {
    private Long id;
    private String questionText;
    private String userAnswerText;
    private boolean isCorrect;
    private int ratingChange;
    private int experienceGained;
    private LocalDateTime datePlayed;
}