package com.csie.examapp.entities;

import jakarta.persistence.Entity;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
public class TestEntity implements Serializable {
    @Id
    @GeneratedValue
    @Getter @Setter private int id;
    @Getter @Setter private int groupId;
    @Getter @Setter private int minRequired;
    
    @ManyToOne
    @JoinColumn(name = "teacherId", referencedColumnName = "id")
    @JsonIgnore
    @Getter @Setter private TeacherEntity teacher;

    @OneToMany(mappedBy="test")
    @Getter @Setter private List<QuestionEntity> questions;

    @OneToMany(mappedBy="test")
    @Getter @Setter private List<TestResultEntity> testResults;
}