package com.csie.examapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csie.examapp.dto.TestResultDto;
import com.csie.examapp.entities.TestResultEntity;
import com.csie.examapp.services.TestResultService;

@RestController
@RequestMapping("/testResult")
public class TestResultController {
    @Autowired
    private TestResultService testResultService;

    private TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @PostMapping
    public TestResultEntity createTestResult(@RequestBody TestResultDto testResultDto) {
        return this.testResultService.createTestResult(testResultDto);
    }
}