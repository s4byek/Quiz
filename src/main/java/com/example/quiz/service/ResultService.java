package com.example.quiz.service;

import com.example.quiz.dto.AnswerResultDTO;
import com.example.quiz.dto.AnswerSubmitDTO;
import com.example.quiz.dto.GameHistoryDTO;
import com.example.quiz.exception.ResourceNotFoundException;
import com.example.quiz.model.*;
import com.example.quiz.repository.AnswerRepository;
import com.example.quiz.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final UserService userService;

    @Transactional
    public AnswerResultDTO submitAnswer(Long userId, AnswerSubmitDTO dto) {
        User user = userService.findById(userId);
        Answer userAnswer = answerRepository.findById(dto.getAnswerId())
                .orElseThrow(() -> new ResourceNotFoundException("Ответ не найден"));

        Question question = userAnswer.getQuestion();
        boolean isCorrect = userAnswer.isCorrect();

        int stake = question.getDifficulty().getStake();
        int reward = question.getDifficulty().getReward();
        int experienceGained = isCorrect ? question.getDifficulty().getExperience() : 0;

        // ЧТО уходит в профиль пользователя
        int ratingDeltaForUser = isCorrect ? reward : 0;

        // ЧТО пишем в историю как изменение рейтинга за игру (чистое)
        int ratingChangeForHistory = isCorrect ? (reward - stake) : (-stake);

        Result result = Result.builder()
                .user(user)
                .question(question)
                .userAnswer(userAnswer)
                .isCorrect(isCorrect)
                .ratingChange(ratingChangeForHistory)
                .experienceGained(experienceGained)
                .build();

        resultRepository.save(result);

        if (ratingDeltaForUser != 0 || experienceGained != 0) {
            user = userService.updateUserStats(userId, ratingDeltaForUser, experienceGained);
        }

        Answer correctAnswer = questionService.getCorrectAnswer(question.getId());

        return AnswerResultDTO.builder()
                .correct(isCorrect)
                .pointsEarned(ratingChangeForHistory)
                .experienceGained(experienceGained)
                .newRating(user.getRating())
                .newExperience(user.getExperience())
                .newLevel(user.getLevel())
                .correctAnswerText(correctAnswer.getText())
                .build();
    }


    public List<GameHistoryDTO> getUserHistory(Long userId) {
        List<Result> results = resultRepository.findByUserIdOrderByDatePlayedDesc(userId);

        return results.stream()
                .map(result -> GameHistoryDTO.builder()
                        .id(result.getId())
                        .questionText(result.getQuestion().getText())
                        .userAnswerText(result.getUserAnswer() != null ?
                                result.getUserAnswer().getText() : "Нет ответа")
                        .isCorrect(result.isCorrect())
                        .ratingChange(result.getRatingChange())
                        .experienceGained(result.getExperienceGained())
                        .datePlayed(result.getDatePlayed())
                        .build())
                .collect(Collectors.toList());
    }
}