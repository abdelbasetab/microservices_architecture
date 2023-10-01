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
    public Question getQuestionById(int id){
        return questionRepository.getById(id);
    }

    public void updateQuestion(Question updated) {


        if (isInDatabase(updated)){
            //delete the saved Question and replace it with the updated one
            questionRepository.deleteById(updated.getId());
            questionRepository.save(updated);
        }

    }

    /**
     * check if our Question already in the database or not
     * @param qst checked Question
     * @return true if in the database
     */
    private boolean isInDatabase(Question qst){
        Question qs = questionRepository.getById(qst.getId());
        if (qs == null){
            return  false;
        }else
            return true;
    }

    public List<Question> getQuestionByCategory(String category) {

        return  questionRepository.getByCategory(category);
    }
}
