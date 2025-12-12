package com.example.quiz.controller;


import com.example.quiz.dto.AnswerResultDTO;
import com.example.quiz.dto.AnswerSubmitDTO;
import com.example.quiz.model.User;
import com.example.quiz.service.ResultService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class AnswerController {

    private final ResultService resultService;

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam Long questionId,
                               @RequestParam Long answerId,
                               HttpSession session,
                               Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        AnswerSubmitDTO dto = new AnswerSubmitDTO();
        dto.setQuestionId(questionId);
        dto.setAnswerId(answerId);

        AnswerResultDTO result = resultService.submitAnswer(userId, dto);
        model.addAttribute("result", result);
        return "quiz/result";
    }
}