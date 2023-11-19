package com.csie.examapp.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TeacherEntity extends UserEntity {

    @Getter
    @Setter
    private String subject;

    public TeacherEntity(String firstName, String lastName, int age, String CNP, String eMail, String subject) {
        super(firstName, lastName, age, CNP, eMail);
        this.subject = subject;
    }

    public TeacherEntity() {
        
    }
}
