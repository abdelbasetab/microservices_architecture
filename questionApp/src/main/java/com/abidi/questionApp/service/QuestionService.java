package com.abidi.questionApp.service;



import com.abidi.questionApp.model.Question;
import com.abidi.questionApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {


    @Autowired
    QuestionRepository questionRepository;

    /**
     * Get All Categories from database and return so form Responce Entity with Http Status Ok
     *
     */
    public ResponseEntity<List<String>> getAllCategories() {
        try {
            return new ResponseEntity<>(questionRepository.getAllCategorie(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        //if something went wrong
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    /**
     * Get All Questions from database and return so form Responce Entity with Http Status Ok
     *
     */
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        //if something went wrong
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    /**
     * save quest
     * @param qst
     * @return success as message in body request and HTTPSatus Code 201
     */
    public ResponseEntity<String> saveQuestion(Question qst){
        questionRepository.save(qst);
        //HTTPSatus Created code : 201
        return new ResponseEntity<>("success", HttpStatus.CREATED);
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

    public ResponseEntity<String> deleteQuestion(Integer id) {

            if(questionRepository.existsById(id)) {
                questionRepository.deleteById(id);
                return new ResponseEntity<>("deleted successful", HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {

        List<Integer> questions = questionRepository.findRandonQuestionsByCategory(categoryName,numQuestions);

        return new ResponseEntity<>(questions,HttpStatus.OK);


    }

    public ResponseEntity<List<Question>> getQuestionsById(List<Integer> questionIds) {

        return new ResponseEntity<>(questionRepository.findAllById(questionIds),HttpStatus.OK);
    }
}
