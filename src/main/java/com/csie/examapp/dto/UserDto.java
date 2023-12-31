package com.csie.examapp.dto;

import org.springframework.stereotype.Component;

import com.csie.examapp.entities.UserEnum;

import io.micrometer.common.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Component
public class UserDto {
    @Getter @Setter private UserEnum userType;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private int age;
    @Getter @Setter private String CNP;
    @Getter @Setter private String eMail;
    @Getter @Setter private String password;
    @Nullable()
    @Getter @Setter private String subject;
    @Nullable()
    @Getter @Setter private int groupId;
}
