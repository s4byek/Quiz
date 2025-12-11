package com.example.quiz.controller;

import com.example.quiz.model.Category;
import com.example.quiz.model.Difficulty;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        model.addAttribute("categories", Category.values());
        model.addAttribute("difficulties", Difficulty.values());
        return "home";
    }
}