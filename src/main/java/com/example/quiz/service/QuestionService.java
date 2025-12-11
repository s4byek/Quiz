package com.example.quiz.service;

import com.example.quiz.dto.AnswerDTO;
import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.dto.UserRegistrationDTO;
import com.example.quiz.dto.UserStatsDTO;
import com.example.quiz.exception.ResourceNotFoundException;
import com.example.quiz.exception.UserAlreadyExistsException;
import com.example.quiz.model.*;
import com.example.quiz.repository.AnswerRepository;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.repository.ResultRepository;
import com.example.quiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    Random random = new Random();

//    public QuestionDTO getRandomQuestion(Category category, Difficulty difficulty) {
//        Question question;
//
//        if (category != null && difficulty != null) {
//            question = questionRepository.findRandomByCategoryAndDifficulty(
//                            category.name(), difficulty.name())
//                    .orElseThrow(() -> new ResourceNotFoundException(
//                            "Вопросы не найдены для категории " + category + " и сложности " + difficulty));
//        } else {
//            question = questionRepository.findRandomQuestion()
//                    .orElseThrow(() -> new ResourceNotFoundException("Вопросы не найдены"));
//        }
//
//        return convertToDTO(question);
//    }
//
//    // Новый метод для получения вопроса с проверкой рейтинга
//    public QuestionDTO getRandomQuestionWithStake(Category category, Difficulty difficulty, User user) {
//        Question question;
//
//        if (category != null && difficulty != null) {
//            question = questionRepository.findRandomByCategoryAndDifficulty(
//                            category.name(), difficulty.name())
//                    .orElseThrow(() -> new ResourceNotFoundException(
//                            "Вопросы не найдены для категории " + category + " и сложности " + difficulty));
//        } else {
//            question = questionRepository.findRandomQuestion()
//                    .orElseThrow(() -> new ResourceNotFoundException("Вопросы не найдены"));
//        }
//
//        // Проверка достаточности рейтинга для ставки
//        int stake = question.getDifficulty().getStake();
//        if (user.getRating() < stake) {
//            throw new RuntimeException("Недостаточно рейтинга! Требуется: " + stake + ", у вас: " + user.getRating());
//        }
//
//        return convertToDTO(question);
//    }
//
//    public QuestionDTO getQuestionById(Long id) {
//        Question question = questionRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Вопрос не найден"));
//        return convertToDTO(question);
//    }
//
//    @Transactional
//    public Question createQuestion(String text, Category category, Difficulty difficulty,
//                                   List<String> answerTexts, int correctAnswerIndex) {
//        Question question = Question.builder()
//                .text(text)
//                .category(category)
//                .difficulty(difficulty)
//                .build();
//
//        question = questionRepository.save(question);
//
//        for (int i = 0; i < answerTexts.size(); i++) {
//            Answer answer = Answer.builder()
//                    .text(answerTexts.get(i))
//                    .isCorrect(i == correctAnswerIndex)
//                    .question(question)
//                    .build();
//            question.addAnswer(answer);
//        }
//
//        return questionRepository.save(question);
//    }

    public Answer getCorrectAnswer(Long questionId) {
        return answerRepository.findCorrectAnswerByQuestionId(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("Правильный ответ не найден"));
    }

    private QuestionDTO convertToDTO(Question question) {
        List<AnswerDTO> answerDTOs = question.getAnswers().stream()
                .map(answer -> AnswerDTO.builder()
                        .id(answer.getId())
                        .text(answer.getText())
                        .build())
                .collect(Collectors.toList());

        return QuestionDTO.builder()
                .id(question.getId())
                .text(question.getText())
                .category(question.getCategory())
                .difficulty(question.getDifficulty())
                .answers(answerDTOs)
                .build();
    }
    public QuestionDTO getRandomQuestionWithStakeExcludingAnswered(
            Category category,
            Difficulty difficulty,
            User user,
            Set<Long> answeredIds
    ) {
        List<Question> allQuestions;
        if (category != null && difficulty != null) {
            allQuestions = questionRepository.findByCategoryAndDifficulty(category, difficulty);
        } else if (category != null) {
            allQuestions = questionRepository.findByCategory(category);
        } else if (difficulty != null) {
            allQuestions = questionRepository.findByDifficulty(difficulty);
        } else {
            allQuestions = questionRepository.findAll();
        }

        // 2) Фильтруем уже отвеченные (если answeredIds == null — не фильтруем)
        List<Question> availableQuestions = allQuestions.stream()
                .filter(q -> answeredIds == null || !answeredIds.contains(q.getId()))
                .collect(Collectors.toList());

        // 3) Если ничего не осталось — кидаем исключение
        if (availableQuestions.isEmpty()) {
            throw new ResourceNotFoundException("Вы ответили на все доступные вопросы");
        }

        // 4) Случайный выбор из оставшихся
        int idx = random.nextInt(availableQuestions.size());
        Question question = availableQuestions.get(idx);

        // 5) Проверяем рейтинг для ставки
        int stake = question.getDifficulty().getStake();
        if (user.getRating() < stake) {
            throw new RuntimeException("Недостаточно рейтинга! Требуется: " + stake + ", у вас: " + user.getRating());
        }

        return convertToDTO(question);
    }
}
