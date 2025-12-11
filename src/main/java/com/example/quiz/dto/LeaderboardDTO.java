package com.example.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardDTO {
    private Long position;
    private Long userId;
    private String username;
    private int rating;
    private int level;
    private int experience;
    private boolean isCurrentUser;
}