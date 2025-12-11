package com.example.quiz.dto;


import com.example.quiz.model.Category;
import com.example.quiz.model.Difficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionFormDTO {
    private Long id;

    @NotBlank(message = "Текст вопроса обязателен")
    private String text;

    @NotNull(message = "Категория обязательна")
    private Category category;

    @NotNull(message = "Сложность обязательна")
    private Difficulty difficulty;

    @Builder.Default
    private List<String> answers = new ArrayList<>();

    @NotNull(message = "Укажите правильный ответ")
    private Integer correctAnswerIndex;

    public void initAnswers() {
        if (answers == null || answers.isEmpty()) {
            answers = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                answers.add("");
            }
        }
    }
}
