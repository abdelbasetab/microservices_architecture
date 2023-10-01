package com.projects.quizApp.controller;


import com.projects.quizApp.model.Question;
import com.projects.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {



    @Autowired
    private QuestionService questionService;
    @GetMapping("/list")
    public List<Question> getALlQuestions(){

        System.out.println(questionService.getAllQuestions());
        return questionService.getAllQuestions();
    }
    @GetMapping("/listSave")
    public void saveQuestion(Question qst){


        questionService.saveQuestion(qst);
    }




}
