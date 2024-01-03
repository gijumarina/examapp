package com.csie.examapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csie.examapp.dto.TestDto;
import com.csie.examapp.dto.TestResultDto;
import com.csie.examapp.dto.TestStateDto;
import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.services.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    private TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/start/{id}")
    public TestStateDto startTest(@PathVariable int id) {
        return testService.startTest(id);
    }

    @GetMapping("/start/{id}/{studentId}")
    public TestStateDto startTest(@PathVariable int id, @PathVariable int studentId) {
        return testService.studentStartTest(id, studentId);
    }

    @PostMapping("/submitAnswer/{id}")
    public TestStateDto submitAnswer(@PathVariable int id, @RequestBody TestResultDto testResultDto) {
        return testService.submitAnswer(testResultDto, id);
    }

    @GetMapping("/end/{id}")
    public TestStateDto endTest(@PathVariable int id) {
        return testService.endTest(id);
    }

    @GetMapping("/end/{id}/{studentId}")
    public TestStateDto endTest(@PathVariable int id, @PathVariable int studentId) {
        return testService.studentEndTest(id, studentId);
    }

    @PostMapping
    public TestEntity createTest(@RequestBody TestDto testDto) {
        return this.testService.createTest(testDto);
    }
}
