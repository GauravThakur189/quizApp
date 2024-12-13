package com.assignment.quizapp.seed;

import com.assignment.quizapp.entity.Question;
import com.assignment.quizapp.entity.User;
import com.assignment.quizapp.repository.QuestionRepository;
import com.assignment.quizapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Seed Questions
        questionRepository.saveAll(Arrays.asList(
                new Question("What is 2+2?", "3", "4", "5", "6", "4"),
                new Question("Which language is used for Android development?", "Java", "Python", "C++", "Swift", "Java"),
                new Question("What is 4+5", "6", "8", "7", "9", "9"),
                new Question("Which language is used for backend development", "Hindi", "English", "Marathi", "Java", "Java"),
                new Question("Which is 5-2", "1", "2", "3", "4", "3")
        ));



        // Seed User
        userRepository.save(new User("Test User"));
    }
}