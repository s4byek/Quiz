package com.example.quiz.dto;

import com.example.quiz.model.Category;
import com.example.quiz.model.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String text;
    private Category category;
    private Difficulty difficulty;
    private List<AnswerDTO> answers;

}