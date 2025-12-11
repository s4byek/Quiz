package com.example.quiz.repository;

import com.example.quiz.dto.CategoryStatsDto;
import com.example.quiz.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByUserIdOrderByDatePlayedDesc(Long userId);

    @Query("SELECT COUNT(r) FROM Result r WHERE r.user.id = :userId AND r.isCorrect = true")
    int countCorrectAnswersByUserId(@Param("userId") Long userId);

    @Query("SELECT COUNT(r) FROM Result r WHERE r.user.id = :userId")
    int countTotalAnswersByUserId(@Param("userId") Long userId);

    @Query("SELECT SUM(r.ratingChange) FROM Result r WHERE r.user.id = :userId")
    Integer sumRatingChangeByUserId(@Param("userId") Long userId);

    @Query("select distinct r.question.id from Result r where r.user.id = :userId")
    List<Long> findAnsweredQuestionIdsByUserId(@Param("userId") Long userId);

    @Query("""
    SELECT new com.example.quiz.dto.CategoryStatsDto(
        r.question.category,
        COUNT(r),
        SUM(CASE WHEN r.isCorrect = true THEN 1 ELSE 0 END),
        AVG(r.ratingChange)
    )
    FROM Result r
    WHERE r.user.id = :userId
    GROUP BY r.question.category
    """)
    List<CategoryStatsDto> getCategoryStatsByUserId(@Param("userId") Long userId);

}