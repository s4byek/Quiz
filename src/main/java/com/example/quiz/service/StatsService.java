package com.example.quiz.service;

import com.example.quiz.dto.CategoryStatsDto;
import com.example.quiz.repository.ResultRepository;
import com.example.quiz.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {

    private final ResultRepository resultRepository;
    private final UserRepository userRepository;

    public StatsService(ResultRepository resultRepository, UserRepository userRepository) {
        this.resultRepository = resultRepository;
        this.userRepository = userRepository;
    }

    public List<CategoryStatsDto> getCategoryStatsForUser(Long userId) {
        return resultRepository.getCategoryStatsByUserId(userId);
    }
}
