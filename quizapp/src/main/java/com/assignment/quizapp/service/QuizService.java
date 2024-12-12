package com.assignment.quizapp.service;

import com.assignment.quizapp.entity.Question;
import com.assignment.quizapp.entity.User;
import com.assignment.quizapp.repository.QuestionRepository;
import com.assignment.quizapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    private Long currentSessionUserId;

    public String startQuizSession() {
        User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));
        currentSessionUserId = user.getId();
        user.resetStats();

        userRepository.save(user);
        return "Quiz session started!";
    }
    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public String submitAnswer(Long questionId, String answer) {
        User user = userRepository.findById(currentSessionUserId).orElseThrow(() -> new RuntimeException("Session user not found"));
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));

        if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
            user.incrementCorrectAnswers();
            return "Correct answer!";
        } else {
            user.incrementIncorrectAnswers();
            return "Incorrect answer.";
        }
    }
    public Map<String, Object> getUserStats() {
        User user = userRepository.findById(currentSessionUserId).orElseThrow(() -> new RuntimeException("Session user not found"));
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalQuestions", user.getCorrectAnswers() + user.getIncorrectAnswers());
        stats.put("correctAnswers", user.getCorrectAnswers());
        stats.put("incorrectAnswers", user.getIncorrectAnswers());
        return stats;
    }
}
