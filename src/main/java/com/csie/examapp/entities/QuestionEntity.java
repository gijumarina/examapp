
package com.csie.examapp.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Entity
public class QuestionEntity implements Serializable {
    @Id
    @GeneratedValue
    @Getter @Setter private int id;

    @Getter @Setter private String text;

    @Enumerated(EnumType.STRING)
    @Getter @Setter private QuestionType type;

    @Getter @Setter private int score;

    @ManyToOne
    @JoinColumn(name="testId", referencedColumnName="id")
    @JsonIgnore
    @Getter @Setter private TestEntity test;

    @OneToMany(mappedBy="question")
    @Getter @Setter private List<AnswerEntity> answers;

}