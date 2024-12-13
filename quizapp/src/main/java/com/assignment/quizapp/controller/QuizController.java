package com.assignment.quizapp.controller;

import com.assignment.quizapp.dto.QuestionDTO;
import com.assignment.quizapp.entity.Question;
import com.assignment.quizapp.entity.User;
import com.assignment.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<String> startQuizSession() {
        return ResponseEntity.ok(quizService.startQuizSession());
    }
        @GetMapping("/question")
        public QuestionDTO getRandomQuestion() {
          return quizService.getRandomQuestion();
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateAnswer(@RequestParam Long questionId, @RequestParam String selectedOption) {
        boolean isCorrect = quizService.validateAnswer(questionId, selectedOption);
        if (isCorrect) {
            return ResponseEntity.ok("Correct answer!");
        } else {
            return ResponseEntity.ok("Incorrect answer.");
        }
    }

    @PostMapping("/answer")
    public ResponseEntity<String> submitAnswer(@RequestParam Long questionId, @RequestParam String answer) {
        return ResponseEntity.ok(quizService.submitAnswer(questionId, answer));
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getUserStats() {
        return ResponseEntity.ok(quizService.getUserStats());
    }
}
