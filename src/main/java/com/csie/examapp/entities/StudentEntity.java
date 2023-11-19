package com.csie.examapp.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class StudentEntity extends UserEntity {

    @Getter
    @Setter
    private int groupId;

    public StudentEntity(String firstName, String lastName, int age, String CNP, String eMail, int groupId) {
        super(firstName, lastName, age, CNP, eMail);
        this.groupId = groupId;
    }

    public StudentEntity() {
        
    }
}
