package com.csie.examapp.dto;

import org.springframework.stereotype.Component;

import com.csie.examapp.entities.QuestionType;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Component
public class QuestionDto {
    @Getter @Setter private String text;
    @Getter @Setter private QuestionType type;
    @Getter @Setter private List<AnswerDto> answers;
}