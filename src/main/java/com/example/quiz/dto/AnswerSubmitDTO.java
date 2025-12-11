package com.example.quiz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnswerSubmitDTO {
    @NotNull(message = "ID вопроса обязателен")
    private Long questionId;

    @NotNull(message = "ID ответа обязателен")
    private Long answerId;
}