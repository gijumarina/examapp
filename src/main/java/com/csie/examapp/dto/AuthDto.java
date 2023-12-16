package com.csie.examapp.dto;

import org.springframework.stereotype.Component;

import com.csie.examapp.entities.UserEnum;

import lombok.Getter;
import lombok.Setter;

@Component
public class AuthDto {
    @Getter @Setter private String eMail;
    @Getter @Setter private String password;
    @Getter @Setter private UserEnum type;
}