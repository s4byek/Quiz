package com.example.quiz.controller;

import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.model.Category;
import com.example.quiz.model.Difficulty;
import com.example.quiz.model.User;
import com.example.quiz.service.QuestionService;
import com.example.quiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/question")
    public String getQuestion(@RequestParam(required = false) Category category,
                              @RequestParam(required = false) Difficulty difficulty,
                              HttpSession session,
                              Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        try {
            User user = userService.findById(userId);

            // Получаем Set отвеченных вопросов из сессии
            @SuppressWarnings("unchecked")
            Set<Long> answeredQuestions = (Set<Long>) session.getAttribute("answeredQuestions");
            if (answeredQuestions == null) {
                answeredQuestions = new HashSet<>();
                session.setAttribute("answeredQuestions", answeredQuestions);
            }

            // Получаем вопрос с проверкой ставки И исключением уже отвеченных
            QuestionDTO question = questionService.getRandomQuestionWithStakeExcludingAnswered(category, difficulty, user, answeredQuestions);

            // Списываем ставку
            int stake = question.getDifficulty().getStake();
            userService.deductStake(userId, stake);

            // Добавляем вопрос в список отвеченных
            answeredQuestions.add(question.getId());

            // Сохраняем ID вопроса в сессии для последующей проверки ответа
            session.setAttribute("currentQuestionId", question.getId());
            session.setAttribute("questionStake", stake);

            model.addAttribute("question", question);
            model.addAttribute("stake", stake);
            model.addAttribute("reward", question.getDifficulty().getReward());
            model.addAttribute("experience", question.getDifficulty().getExperience());
            model.addAttribute("answeredCount", answeredQuestions.size());

            return "quiz/question";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("categories", Category.values());
            model.addAttribute("difficulties", Difficulty.values());
            return "home";
        }
    }
}
