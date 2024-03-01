package com.projects.quizApp.service;

import com.projects.quizApp.feign.QuestionInterface;
import com.projects.quizApp.model.Question;
import com.projects.quizApp.model.Response;
import com.projects.quizApp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizService {


    @Autowired
    QuizRepository quizRepository ;
    @Autowired
    QuestionInterface questionInterface;
    public ResponseEntity<String> createQuiz(String category, int numQs, String titel) {
//        List<Question> questions = questionRepository.findRandonQuestionsByCategory(category,numQs);
//        Quiz quiz = new Quiz();
//        quiz.setTitel(titel);
//        quiz.setQuestioons(questions);
//        quizRepository.save(quiz);
        return new ResponseEntity<>("quiz Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getQuizQuestions(int id) {

//        //get Quiz from Database
//        Quiz quiz = quizRepository.getById(id);
//        //get the reference Questions from Database
//        List<Question> questionsFromDb = quiz.getQuestioons();
//
//
//
//        return  new ResponseEntity<>(questionsFromDb,HttpStatus.OK);
        return null;

    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responces) {
//        Quiz quiz = quizRepository.findById(id).get();
//        List<Question> questions = quiz.getQuestioons();
//        int points =0;
//        for (Response rp :responces){
//
//           for (Question qs : questions){
//               if (rp.getId()==qs.getId() && rp.getResponse().equals(qs.getRightAnswer())){
//                   points++;
//               }
//           }
//        }
        return null;//new ResponseEntity<>(points,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getQuestionsNumbers() {

        return new ResponseEntity<>(questionInterface.getALlQuestions().getBody().size(),HttpStatus.OK);

    }
}
