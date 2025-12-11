package com.example.quiz.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int rating = 0;

    @Column(nullable = false)
    private int experience = 0;

    @Column(nullable = false)
    private int level = 1;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Result> results = new ArrayList<>();

    public void addExperience(int exp) {
        this.experience += exp;
        this.level = this.experience / 100 + 1;
    }

    public void addRating(int points) {
        this.rating += points;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }
}