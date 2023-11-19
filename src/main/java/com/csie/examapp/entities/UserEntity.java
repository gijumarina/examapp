package com.csie.examapp.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@AllArgsConstructor
@Getter
@Setter
@Component
public class UserEntity {
    @Id
    @GeneratedValue
    int id;
    String firstName;
    String lastName;
    int age;
    String CNP;
    String eMail;

    public UserEntity(String firstName, String lastName, int age, String CNP, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.CNP = CNP;
        this.eMail = eMail;
    }

    public UserEntity() {
        
    }

}
