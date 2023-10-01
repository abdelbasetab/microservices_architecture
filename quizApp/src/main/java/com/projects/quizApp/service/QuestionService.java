package com.projects.quizApp.service;


import com.projects.quizApp.model.Question;
import com.projects.quizApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.CompositeData;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }


    public void saveQuestion(Question qst){
        questionRepository.save(qst);
    }
}
