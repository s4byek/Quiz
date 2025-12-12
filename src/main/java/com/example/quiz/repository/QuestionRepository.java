package com.example.quiz.repository;

import com.example.quiz.model.Category;
import com.example.quiz.model.Difficulty;
import com.example.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCategory(Category category);
    List<Question> findByDifficulty(Difficulty difficulty);
    List<Question> findByCategoryAndDifficulty(Category category, Difficulty difficulty);

    @Query(value = "SELECT * FROM questions q WHERE q.category = :category AND q.difficulty = :difficulty ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Question> findRandomByCategoryAndDifficulty(
            @Param("category") String category,
            @Param("difficulty") String difficulty
    );

    @Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Question> findRandomQuestion();


    //Для амдники
    @Query("SELECT q FROM Question q " +
            "WHERE (:category IS NULL OR q.category = :category) " +
            "  AND (:difficulty IS NULL OR q.difficulty = :difficulty) " +
            "  AND (:search IS NULL OR LOWER(q.text) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "ORDER BY q.category, q.difficulty, q.id")
    List<Question> findByFilters(
            @Param("category") Category category,
            @Param("difficulty") Difficulty difficulty,
            @Param("search") String search
    );
}