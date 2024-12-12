package com.assignment.quizapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "QUIZ_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int correctAnswers;
    private int incorrectAnswers;

    public User(String testUser) {
    }

    public User(){

    }

    public Long getId() {
        return this.id;
    }

    public int getCorrectAnswers() {
        return this.correctAnswers;
    }

    public int getIncorrectAnswers() {
        return this.incorrectAnswers;
    }


    public void resetStats() {
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
    }

    public void incrementCorrectAnswers() {
        this.correctAnswers++;
    }

    public void incrementIncorrectAnswers() {
        this.incorrectAnswers++;
    }
}
