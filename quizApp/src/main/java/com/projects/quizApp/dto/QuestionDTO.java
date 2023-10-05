package com.projects.quizApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Question Data transfer Object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private Integer id;
    private String questionTitel;
    private String category;
    private String options1;
    private String options2;
    private String options3;
    private String options4;



}
