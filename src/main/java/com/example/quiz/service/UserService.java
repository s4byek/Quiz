package com.example.quiz.service;

import com.example.quiz.dto.*;
import com.example.quiz.exception.ResourceNotFoundException;
import com.example.quiz.exception.UserAlreadyExistsException;
import com.example.quiz.model.Role;
import com.example.quiz.model.User;
import com.example.quiz.repository.ResultRepository;
import com.example.quiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ResultRepository resultRepository;

    @Transactional
    public User registerUser(UserRegistrationDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UserAlreadyExistsException("Пользователь с таким именем уже существует");
        }

        User user = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .rating(100)  // Начальный рейтинг 100 для возможности играть
                .experience(0)
                .level(1)
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    public User loginUser(UserLoginDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Неверный пароль");
        }

        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));
    }

    @Transactional
    public User updateUserStats(Long userId, int ratingChange, int experienceGained) {
        User user = findById(userId);
        user.addRating(ratingChange);
        user.addExperience(experienceGained);
        return userRepository.save(user);
    }

    // Списание ставки при входе в вопрос
    @Transactional
    public User deductStake(Long userId, int stake) {
        User user = findById(userId);
        if (user.getRating() < stake) {
            throw new RuntimeException("Недостаточно рейтинга для ставки!");
        }
        user.addRating(-stake); // Списываем ставку
        return userRepository.save(user);
    }

    public UserStatsDTO getUserStats(Long userId) {
        User user = findById(userId);
        int totalAnswers = resultRepository.countTotalAnswersByUserId(userId);
        int correctAnswers = resultRepository.countCorrectAnswersByUserId(userId);
        double accuracy = totalAnswers > 0 ? (double) correctAnswers / totalAnswers * 100 : 0;

        return UserStatsDTO.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .rating(user.getRating())
                .experience(user.getExperience())
                .level(user.getLevel())
                .totalAnswers(totalAnswers)
                .correctAnswers(correctAnswers)
                .accuracy(Math.round(accuracy * 100.0) / 100.0)
                .build();
    }

    public List<LeaderboardDTO> getTopUsers(Long currentUserId) {
        List<User> topUsers = userRepository.findTop10ByOrderByRatingDescExperienceDesc();
        List<LeaderboardDTO> leaderboard = new ArrayList<>();

        for (int i = 0; i < topUsers.size(); i++) {
            User user = topUsers.get(i);
            leaderboard.add(LeaderboardDTO.builder()
                    .position((long) (i + 1))
                    .userId(user.getId())
                    .username(user.getUsername())
                    .rating(user.getRating())
                    .level(user.getLevel())
                    .experience(user.getExperience())
                    .isCurrentUser(user.getId().equals(currentUserId))
                    .build());
        }

        return leaderboard;
    }

    // Получить позицию пользователя
    public LeaderboardDTO getCurrentUserPosition(Long userId) {
        User user = findById(userId);
        long position = userRepository.getUserPosition(user.getRating(), user.getExperience());

        return LeaderboardDTO.builder()
                .position(position)
                .userId(user.getId())
                .username(user.getUsername())
                .rating(user.getRating())
                .level(user.getLevel())
                .experience(user.getExperience())
                .isCurrentUser(true)
                .build();
    }

}