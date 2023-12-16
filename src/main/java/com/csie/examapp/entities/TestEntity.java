package com.csie.examapp.entities;

import jakarta.persistence.Entity;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
public class TestEntity {
    @Id
    @GeneratedValue
    @Getter @Setter private int id;
    @Getter @Setter private String subject;
    @Getter @Setter private int groupId;
    
    @ManyToOne
    @JoinColumn(name = "teacherId", referencedColumnName = "id")
    @Getter @Setter private TeacherEntity teacher;

    @OneToMany(mappedBy="test")
    @Getter @Setter private List<QuestionEntity> questions;
}