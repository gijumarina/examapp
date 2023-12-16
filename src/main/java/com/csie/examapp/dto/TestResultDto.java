package com.csie.examapp.dto;

import org.springframework.stereotype.Component;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Component
public class TestResultDto {
    @Getter @Setter private int result;
    @Getter @Setter private int studentId;
    @Getter @Setter private int testId;
}