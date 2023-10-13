package com.example.quizService.controller;


import com.example.quizService.entities.Quiz;
import com.example.quizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create/{quizType}/{qNum}")
    public String createQuiz(@PathVariable(name="quizType") String quizType,
                             @PathVariable(name="qNum") int qNum){
        return quizService.createQuiz(quizType, qNum);
    }
}
