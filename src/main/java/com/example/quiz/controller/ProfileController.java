package com.example.quiz.controller;


import com.example.quiz.dto.*;
import com.example.quiz.model.User;
import com.example.quiz.service.ResultService;
import com.example.quiz.service.StatsService;
import com.example.quiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;
    private final ResultService resultService;
    private final StatsService statsService;

    @GetMapping
    public String getProfile(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        UserStatsDTO stats = userService.getUserStats(userId);
        List<GameHistoryDTO> history = resultService.getUserHistory(userId);

        List<CategoryStatsDto> categoryStats =
                statsService.getCategoryStatsForUser(userId);

        model.addAttribute("stats", stats);
        model.addAttribute("history", history);
        model.addAttribute("categoryStats", categoryStats);
        return "profile/profile";
    }
}