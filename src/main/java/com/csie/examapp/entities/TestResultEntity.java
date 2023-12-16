package com.csie.examapp.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.entities.TestEntity;

import java.io.Serializable;

@Entity
public class TestResultEntity implements Serializable {
    @Id
    @GeneratedValue
    @Getter @Setter private int id;

    @Getter @Setter private int result;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    @JsonIgnore
    @Getter @Setter private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "testId", referencedColumnName = "id")
    @JsonIgnore
    @Getter @Setter private TestEntity test;
}