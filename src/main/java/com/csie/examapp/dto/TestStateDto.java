package com.csie.examapp.dto;

import org.springframework.stereotype.Component;

import io.micrometer.common.lang.Nullable;

import com.csie.examapp.entities.TestResultEntity;

import lombok.Getter;
import lombok.Setter;

public class TestStateDto {
    @Getter @Setter private String message;
    @Nullable()
    @Getter @Setter private TestResultEntity testResult;
}