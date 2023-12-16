package com.csie.examapp.services;

import java.util.ArrayList;
import java.util.List;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.entities.TeacherEntity;
import com.csie.examapp.entities.QuestionEntity;
import com.csie.examapp.dto.TestDto;
import com.csie.examapp.dto.QuestionDto;
import com.csie.examapp.repositories.TestRepository;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    private QuestionService questionService;
    private TeacherService teacherService;
    private TestRepository testRepository;
    
    private TestService(QuestionService questionService, TeacherService teacherService, TestRepository testRepository) {
        this.questionService = questionService;
        this.teacherService = teacherService;
        this.testRepository = testRepository;
    }

    public TestEntity getById(int id) {
        return this.testRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Can not find test with id: " + id));
    }

    public TestEntity createTest(TestDto testDto) {
        TestEntity test = new TestEntity();
        TeacherEntity teacher = teacherService.getById(testDto.getTeacherId());
        test.setTeacher(teacher);
        test.setGroupId(testDto.getGroupId());
        test.setMinRequired(testDto.getMinRequired());
        TestEntity newTest = testRepository.save(test);
        List<QuestionEntity> questions = new ArrayList<>();
        for(QuestionDto question : testDto.getQuestions()) {
            QuestionEntity newQuestion = this.questionService.createQuestion(question, newTest);
            questions.add(newQuestion);
        }
        newTest.setQuestions(questions);
        return newTest;
    }
}
