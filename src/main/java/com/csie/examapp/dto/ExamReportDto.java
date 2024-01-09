package com.csie.examapp.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class ExamReportDto {
    @Getter @Setter int noOfQuestions;
    @Getter @Setter int noOfMultipleChoice;
    @Getter @Setter int noOfMultipleAnswer;
    @Getter @Setter int noOfOpenAnswers;
}