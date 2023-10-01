package com.projects.quizApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String category;
    private String options1;
    private String options2;
    private String difficultLevel;





}
