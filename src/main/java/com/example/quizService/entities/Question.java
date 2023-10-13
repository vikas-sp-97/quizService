package com.example.quizService.entities;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private String quizType;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
