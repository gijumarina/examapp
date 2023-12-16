package com.csie.examapp.dto;

import org.springframework.stereotype.Component;

import com.csie.examapp.entities.QuestionType;

import lombok.Getter;
import lombok.Setter;

@Component
public class AnswerDto {
    @Getter @Setter private String text;
    @Getter @Setter private boolean isCorrect;
}