package com.csie.examapp.entities;

import jakarta.persistence.Entity;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
public class AnswerEntity {
    @Id
    @GeneratedValue
    @Getter @Setter private int id;
    @Getter @Setter private String text;
    @Getter @Setter private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name="questionId", referencedColumnName="id")
    @Getter @Setter private QuestionEntity question;

}