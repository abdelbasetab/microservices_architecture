package com.projects.quizApp.repository;


import com.projects.quizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> getByCategory(String category);



    @Query(value = "SELECT * FROM question q WHERE q.category= :category ORDER BY RANDOM() LIMIT :numQs",nativeQuery = true)
    List<Question> findRandonQuestionsByCategory(String category, int numQs);

    @Query(value = "SELECT DISTINCT category FROM question",nativeQuery = true)
    List<String> getAllCategorie();

}
