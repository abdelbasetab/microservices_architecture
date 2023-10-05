package com.projects.quizApp.controller;


import com.projects.quizApp.dto.QuestionDTO;
import com.projects.quizApp.dto.Response;
import com.projects.quizApp.model.Question;
import com.projects.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQs,@RequestParam String titel){


        return quizService.createQuiz(category,numQs,titel);

    }


    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(@PathVariable int id){

        return quizService.getQuizQuestions(id);
    }

    /**
     * we will get the responces in the request Body
     * @param id
     * @return
     */
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responces ) {

        return quizService.calculateResult(id,responces);

    }


}
