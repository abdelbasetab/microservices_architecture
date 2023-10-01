package com.projects.quizApp.controller;


import com.projects.quizApp.model.Question;
import com.projects.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    public void saveQuestion(Question qst){
        questionService.saveQuestion(qst);
/**
        Question qs1= new Question();
        qs1.setCategory("java");
        qs1.setDifficultLevel("hard");
        qs1.setOptions1("array");
        qs1.setOptions2("not primitive");
        Question qs2= new Question();
        qs2.setCategory("c#");
        qs2.setDifficultLevel("easy");
        qs2.setOptions1("zeiger");
        qs2.setOptions2("contruct");
        Question qs3= new Question();
        qs3.setCategory("javascript");
        qs3.setDifficultLevel("hard");
        qs3.setOptions1("varibale");
        qs3.setOptions2("variable");
        Question qs4= new Question();
        qs4.setCategory("c++");
        qs4.setDifficultLevel("hard");
        qs4.setOptions1("char type");
        qs4.setOptions2("characters  ");
        List<Question> temp_qsts = new ArrayList<>();
        temp_qsts.add(qs1);
        temp_qsts.add(qs2);
        temp_qsts.add(qs3);
        temp_qsts.add(qs4);
        for (int i=0;i<temp_qsts.size();i++){
            questionService.saveQuestion(temp_qsts.get(i));
        }
 */

    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);

        }



    public void updateQuestion(Question updated){
         questionService.updateQuestion(updated);

    }






}
