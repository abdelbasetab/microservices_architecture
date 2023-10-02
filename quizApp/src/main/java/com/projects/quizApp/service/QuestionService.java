package com.projects.quizApp.service;


import com.projects.quizApp.model.Question;
import com.projects.quizApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    /**
     * save quest
     * @param qst
     * @return
     */
    public String saveQuestion(Question qst){
        questionRepository.save(qst);
        return "success";
    }
    public Question getQuestionById(int id){
        return questionRepository.getById(id);
    }

    public String updateQuestion(Question updated) {
            questionRepository.save(updated);
            return "updated successful";

    }

    public List<Question> getQuestionByCategory(String category) {

        return  questionRepository.getByCategory(category);
    }

    public String deleteQuestion(Integer id) {

        questionRepository.deleteById(id);
        return "deleted successful";
    }
}
