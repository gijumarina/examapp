package com.csie.examapp.entities;

import jakarta.persistence.Entity;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
public class AnswerEntity implements Serializable {
    @Id
    @GeneratedValue
    @Getter @Setter private int id;
    @Getter @Setter private String text;
    @Getter @Setter private boolean correct;

    @ManyToOne
    @JoinColumn(name="questionId", referencedColumnName="id")
    @JsonIgnore
    @Getter @Setter private QuestionEntity question;

}