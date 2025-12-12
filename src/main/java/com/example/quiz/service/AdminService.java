package com.example.quiz.service;

import com.example.quiz.dto.QuestionFormDTO;
import com.example.quiz.dto.QuestionListDTO;
import com.example.quiz.exception.ResourceNotFoundException;
import com.example.quiz.model.Answer;
import com.example.quiz.model.Category;
import com.example.quiz.model.Difficulty;
import com.example.quiz.model.Question;
import com.example.quiz.repository.AnswerRepository;
import com.example.quiz.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public List<QuestionListDTO> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(q -> QuestionListDTO.builder()
                        .id(q.getId())
                        .text(q.getText())
                        .category(q.getCategory())
                        .difficulty(q.getDifficulty())
                        .answersCount(q.getAnswers().size())
                        .build())
                .collect(Collectors.toList());
    }
    public QuestionFormDTO getQuestionForEdit(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Вопрос не найден"));

        List<String> answerTexts = question.getAnswers().stream()
                .map(Answer::getText)
                .collect(Collectors.toList());

        int correctIndex = 0;
        for (int i = 0; i < question.getAnswers().size(); i++) {
            if (question.getAnswers().get(i).isCorrect()) {
                correctIndex = i;
                break;
            }
        }

        return QuestionFormDTO.builder()
                .id(question.getId())
                .text(question.getText())
                .category(question.getCategory())
                .difficulty(question.getDifficulty())
                .answers(answerTexts)
                .correctAnswerIndex(correctIndex)
                .build();
    }

    @Transactional
    public Question createQuestion(QuestionFormDTO dto) {
        Question question = Question.builder()
                .text(dto.getText())
                .category(dto.getCategory())
                .difficulty(dto.getDifficulty())
                .build();

        question = questionRepository.save(question);

        for (int i = 0; i < dto.getAnswers().size(); i++) {
            Answer answer = Answer.builder()
                    .text(dto.getAnswers().get(i))
                    .isCorrect(i == dto.getCorrectAnswerIndex())
                    .question(question)
                    .build();
            question.addAnswer(answer);
        }

        return questionRepository.save(question);
    }

    @Transactional
    public Question updateQuestion(Long id, QuestionFormDTO dto) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Вопрос не найден"));

        question.setText(dto.getText());
        question.setCategory(dto.getCategory());
        question.setDifficulty(dto.getDifficulty());

        // Удаляем старые ответы
        question.getAnswers().clear();
        answerRepository.deleteAll(answerRepository.findByQuestionId(id));

        // Добавляем новые ответы
        for (int i = 0; i < dto.getAnswers().size(); i++) {
            Answer answer = Answer.builder()
                    .text(dto.getAnswers().get(i))
                    .isCorrect(i == dto.getCorrectAnswerIndex())
                    .question(question)
                    .build();
            question.addAnswer(answer);
        }

        return questionRepository.save(question);
    }

    // Удалить вопрос
    @Transactional
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Вопрос не найден"));

        questionRepository.delete(question);
    }

    //филтьтры
    public List<QuestionListDTO> getAllQuestionsFiltered(Category category, Difficulty difficulty, String search) {
        List<Question> questions = questionRepository.findByFilters(category, difficulty, (search == null || search.isBlank()) ? null : search.trim());
        return questions.stream()
                .map(q -> QuestionListDTO.builder()
                        .id(q.getId())
                        .text(q.getText())
                        .category(q.getCategory())
                        .difficulty(q.getDifficulty())
                        .answersCount(q.getAnswers() == null ? 0 : q.getAnswers().size())
                        .build())
                .collect(Collectors.toList());
    }
}