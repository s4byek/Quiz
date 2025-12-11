package com.example.quiz.controller;



import com.example.quiz.dto.GameHistoryDTO;
import com.example.quiz.dto.UserLoginDTO;
import com.example.quiz.dto.UserRegistrationDTO;
import com.example.quiz.dto.UserStatsDTO;
import com.example.quiz.model.User;
import com.example.quiz.service.ResultService;
import com.example.quiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserRegistrationDTO());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") UserRegistrationDTO dto,
                           BindingResult result,
                           HttpSession session,
                           Model model) {
        if (result.hasErrors()) {
            return "auth/register";
        }

        try {
            User user = userService.registerUser(dto);
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userRole", user.getRole().name());
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "auth/register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserLoginDTO());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") UserLoginDTO dto,
                        BindingResult result,
                        HttpSession session,
                        Model model) {
        if (result.hasErrors()) {
            return "auth/login";
        }

        try {
            User user = userService.loginUser(dto);
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userRole", user.getRole().name());
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "Неверный логин или пароль");
            return "auth/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}