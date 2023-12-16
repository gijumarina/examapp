package com.csie.examapp.dto;

import org.springframework.stereotype.Component;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Component
public class TestAnswerDto {
    @Getter @Setter private int questionId;
    @Getter @Setter private List<Integer> answersIds;
}