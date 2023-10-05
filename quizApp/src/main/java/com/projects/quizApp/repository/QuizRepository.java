package com.projects.quizApp.repository;

import com.projects.quizApp.model.Question;
import com.projects.quizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {

    @Query(value = "SELECT * FROm question q WHERE q.category= :category ORDER BY RANDOM() LIMIT :numQs",nativeQuery = true)
    List<Question> findRandonQuestionsByCategory(String category, int numQs);
}
