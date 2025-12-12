package com.example.quiz.controller;

import com.example.quiz.dto.LeaderboardDTO;
import com.example.quiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/leaders")
@RequiredArgsConstructor
public class LeaderboardController {

    private final UserService userService;

    @GetMapping
    public String getLeaderboard(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        // Получаем топ-10
        List<LeaderboardDTO> topUsers = userService.getTopUsers(userId);
        model.addAttribute("leaders", topUsers);

        // проверка на пристутвие в топ 10
        boolean inTop10 = topUsers.stream().anyMatch(LeaderboardDTO::isCurrentUser);

        // Если нет показываем отдельно
        if (!inTop10) {
            LeaderboardDTO currentUser = userService.getCurrentUserPosition(userId);
            model.addAttribute("currentUser", currentUser);
        }

        return "leaderboard";
    }
}