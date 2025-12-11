package com.example.quiz.repository;

import com.example.quiz.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);

    @Query("SELECT a FROM Answer a WHERE a.question.id = :questionId AND a.isCorrect = true")
    Optional<Answer> findCorrectAnswerByQuestionId(@Param("questionId") Long questionId);
}