package com.csie.examapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class StudentEntity extends UserEntity {

    @Getter
    @Setter
    private int groupId;

    @OneToMany(mappedBy="student")
    @Getter @Setter private List<TestResultEntity> testResults;

    public StudentEntity(String firstName, String lastName, int age, String CNP, String eMail, int groupId, String password) {
        super(firstName, lastName, age, CNP, eMail, password);
        this.groupId = groupId;
    }

    public StudentEntity() {
        
    }
}
