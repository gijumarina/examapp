package com.csie.examapp.dto;

import org.springframework.stereotype.Component;

import java.util.List;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Component
public class TestDto {
    @Getter @Setter private int groupId;
    @Getter @Setter private int teacherId;
    @Getter @Setter private int minRequired;
    @Getter @Setter private List<QuestionDto> questions;
    @Getter @Setter private LocalDateTime startTime;
    @Getter @Setter private int testDurationMinutes;
}