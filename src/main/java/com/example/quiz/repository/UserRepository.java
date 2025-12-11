package com.example.quiz.repository;

import com.example.quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

    // Топ-10 пользователей по рейтингу
    List<User> findTop10ByOrderByRatingDescExperienceDesc();

    // Позиция пользователя в общем рейтинге
    @Query("SELECT COUNT(u) + 1 FROM User u WHERE u.rating > :rating OR (u.rating = :rating AND u.experience > :experience)")
    long getUserPosition(int rating, int experience);
}
