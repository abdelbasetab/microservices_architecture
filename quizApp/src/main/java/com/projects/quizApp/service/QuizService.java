package com.projects.quizApp.service;

import com.projects.quizApp.dto.QuestionDTO;
import com.projects.quizApp.dto.Response;
import com.projects.quizApp.model.Question;
import com.projects.quizApp.model.Quiz;
import com.projects.quizApp.repository.QuestionRepository;
import com.projects.quizApp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {


    @Autowired
    QuizRepository quizRepository ;
    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<String> createQuiz(String category, int numQs, String titel) {
        List<Question> questions = questionRepository.findRandonQuestionsByCategory(category,numQs);
        Quiz quiz = new Quiz();
        quiz.setTitel(titel);
        quiz.setQuestioons(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("quiz Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(int id) {

        //get Quiz from Database
        Quiz quiz = quizRepository.getById(id);
        //get the reference Questions from Database
        List<Question> questionsFromDb = quiz.getQuestioons();

        List<QuestionDTO> questionsForUser = new ArrayList<>();
        //Convert the Question to questions Dto (question without right answer )
        for (Question q : questionsFromDb){
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(q.getId());
            questionDTO.setQuestionTitel(q.getQuestionTitel());
            questionDTO.setCategory(q.getCategory());
            questionDTO.setOptions1(q.getOptions1());
            questionDTO.setOptions2(q.getOptions2());
            questionDTO.setOptions3(q.getOptions3());
            questionDTO.setOptions4(q.getOptions4());

            questionsForUser.add(questionDTO);
        }

        return  new ResponseEntity<>(questionsForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responces) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestioons();
        int points =0;
        for (Response rp :responces){

           for (Question qs : questions){
               if (rp.getId()==qs.getId() && rp.getResponse().equals(qs.getRightAnswer())){
                   points++;
               }
           }
        }
        return new ResponseEntity<>(points,HttpStatus.OK);
    }
}
