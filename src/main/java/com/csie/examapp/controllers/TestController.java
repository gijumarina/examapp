package com.csie.examapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csie.examapp.dto.TestDto;
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

    @PostMapping
    public TestEntity createTest(@RequestBody TestDto testDto) {
        return this.testService.createTest(testDto);
    }
}
