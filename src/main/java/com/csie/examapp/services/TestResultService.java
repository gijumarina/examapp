package com.csie.examapp.services;

import java.util.ArrayList;
import java.util.List;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.dto.TestResultDto;
import com.csie.examapp.repositories.TestResultRepository;

import org.springframework.stereotype.Service;

@Service
public class TestResultService {
    
    private TestResultRepository testResultRepository;

    private TestResultService(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }
}