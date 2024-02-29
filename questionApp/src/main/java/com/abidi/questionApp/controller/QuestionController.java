package com.abidi.questionApp.controller;


import com.abidi.questionApp.model.Question;
import com.abidi.questionApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {



    @Autowired
    private QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getALlQuestions(){

        return questionService.getAllQuestions();
    }
    @GetMapping("/Categories")
    public ResponseEntity<List<String>> getALlCategories(){

        return questionService.getAllCategories();
    }

    @PostMapping("/add")
    public ResponseEntity<String> saveQuestion(@RequestBody Question qst){

        return  questionService.saveQuestion(qst);

    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);

        }
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);

    }

    @PostMapping("/update")
    public String updateQuestion(@RequestBody Question updated){
         return questionService.updateQuestion(updated);
    }






}
