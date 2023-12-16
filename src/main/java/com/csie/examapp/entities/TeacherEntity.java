package com.csie.examapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
public class TeacherEntity extends UserEntity {

    @Getter
    @Setter
    private String subject;

    @OneToMany(mappedBy="teacher")
    @Getter @Setter private List<TestEntity> tests;

    public TeacherEntity(String firstName, String lastName, int age, String CNP, String eMail, String subject) {
        super(firstName, lastName, age, CNP, eMail);
        this.subject = subject;
    }

    public TeacherEntity() {
        
    }
}
