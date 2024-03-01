package com.projects.quizApp.feign;

import com.projects.quizApp.model.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuestionInterface {


    @GetMapping("questions/allQuestions")
    public ResponseEntity<List<Question>> getALlQuestions();

}
