package com.example.quizService.service;

import com.example.quizService.entities.Question;
import com.example.quizService.entities.Quiz;
import com.example.quizService.feign.QuizInterface;
import com.example.quizService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuizInterface quizInterface;

    public String createQuiz(String quizType, int qNum) {

        Quiz quiz = new Quiz();

        quiz.setCategory(quizType);
        quiz.setNoOfQuestions(qNum);

        List<Question> questions = quizInterface.getAll();
        List<Integer> question_ids = questions.stream().map(Question::getId).collect(Collectors.toList());
        quiz.setQuestions(question_ids);
        quizRepository.save(quiz);

        return "Success";
    }
}
