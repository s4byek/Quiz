package com.example.quiz.controller;


import com.example.quiz.dto.QuestionFormDTO;
import com.example.quiz.dto.QuestionListDTO;
import com.example.quiz.model.Category;
import com.example.quiz.model.Difficulty;
import com.example.quiz.model.Role;
import com.example.quiz.model.User;
import com.example.quiz.service.AdminService;
import com.example.quiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;

    // Проверка прав администратора
    private boolean checkAdmin(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return false;
        }

        User user = userService.findById(userId);
        if (user.getRole() != Role.ADMIN) {
            model.addAttribute("error", "Доступ запрещён. Требуются права администратора.");
            return false;
        }

        return true;
    }

    // Главная страница админки
    @GetMapping
    public String adminHome(HttpSession session, Model model) {
        if (!checkAdmin(session, model)) {
            return "redirect:/";
        }

        return "redirect:/admin/questions";
    }

    // Список всех вопросов
    @GetMapping("/questions")
    public String listQuestions(HttpSession session, Model model) {
        if (!checkAdmin(session, model)) {
            return "redirect:/";
        }

        List<QuestionListDTO> questions = adminService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "admin/questions";
    }

    // Форма добавления вопроса
    @GetMapping("/add-question")
    public String showAddForm(HttpSession session, Model model) {
        if (!checkAdmin(session, model)) {
            return "redirect:/";
        }

        QuestionFormDTO dto = new QuestionFormDTO();
        dto.initAnswers();

        model.addAttribute("question", dto);
        model.addAttribute("categories", Category.values());
        model.addAttribute("difficulties", Difficulty.values());
        return "admin/add-question";
    }

    // Сохранение нового вопроса
    @PostMapping("/add-question")
    public String addQuestion(@Valid @ModelAttribute("question") QuestionFormDTO dto,
                              BindingResult result,
                              HttpSession session,
                              Model model) {
        if (!checkAdmin(session, model)) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            model.addAttribute("categories", Category.values());
            model.addAttribute("difficulties", Difficulty.values());
            return "admin/add-question";
        }

        adminService.createQuestion(dto);
        return "redirect:/admin/questions";
    }

    // Форма редактирования вопроса
    @GetMapping("/edit-question/{id}")
    public String showEditForm(@PathVariable Long id, HttpSession session, Model model) {
        if (!checkAdmin(session, model)) {
            return "redirect:/";
        }

        QuestionFormDTO dto = adminService.getQuestionForEdit(id);
        model.addAttribute("question", dto);
        model.addAttribute("categories", Category.values());
        model.addAttribute("difficulties", Difficulty.values());
        return "admin/edit-question";
    }

    // Обновление вопроса
    @PostMapping("/edit-question/{id}")
    public String updateQuestion(@PathVariable Long id,
                                 @Valid @ModelAttribute("question") QuestionFormDTO dto,
                                 BindingResult result,
                                 HttpSession session,
                                 Model model) {
        if (!checkAdmin(session, model)) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            model.addAttribute("categories", Category.values());
            model.addAttribute("difficulties", Difficulty.values());
            return "admin/edit-question";
        }

        adminService.updateQuestion(id, dto);
        return "redirect:/admin/questions";
    }

    // Удаление вопроса
    @PostMapping("/delete-question/{id}")
    public String deleteQuestion(@PathVariable Long id, HttpSession session, Model model) {
        if (!checkAdmin(session, model)) {
            return "redirect:/";
        }

        adminService.deleteQuestion(id);
        return "redirect:/admin/questions";
    }
}