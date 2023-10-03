package com.projects.quizApp.controller;


import com.projects.quizApp.model.Question;
import com.projects.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {



    @Autowired
    private QuestionService questionService;
    @GetMapping("/allQuestions")
    public List<Question> getALlQuestions(){

        System.out.println(questionService.getAllQuestions());
        return questionService.getAllQuestions();
    }


    @PostMapping("/add")
    public ResponseEntity<String> saveQuestion(@RequestBody Question qst){
        return new ResponseEntity<>(questionService.saveQuestion(qst), HttpStatus.OK);

    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);

        }
    @PostMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);

    }



    @PostMapping("/update")
    public String updateQuestion(@RequestBody Question updated){
         return questionService.updateQuestion(updated);
    }






}
