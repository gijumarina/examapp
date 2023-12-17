package com.csie.examapp.services;

import java.util.ArrayList;
import java.util.List;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.entities.TeacherEntity;
import com.csie.examapp.entities.QuestionEntity;
import com.csie.examapp.dto.TestDto;
import com.csie.examapp.dto.TestResultDto;
import com.csie.examapp.dto.QuestionDto;
import com.csie.examapp.dto.TestStateDto;
import com.csie.examapp.repositories.TestRepository;
import com.csie.examapp.state.TestContext;
import com.csie.examapp.state.TestContextManager;
import com.csie.examapp.utils.Constants;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    private QuestionService questionService;
    private TeacherService teacherService;
    private TestRepository testRepository;
    private TestResultService testResultService;
    private TestContextManager testContextManager;
    
    private TestService(QuestionService questionService, TeacherService teacherService, TestRepository testRepository,
        TestResultService testResultService, TestContextManager testContextManager) {
        this.questionService = questionService;
        this.teacherService = teacherService;
        this.testRepository = testRepository;
        this.testResultService = testResultService;
        this.testContextManager = testContextManager;
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

    public TestStateDto startTest(int id) {
        TestContext testContext = testContextManager.getTestContext(id);
        if(testContext == null) {
            testContext = testContextManager.createTestContext(id);
        }
        TestStateDto testStateDto = new TestStateDto();
        testStateDto.setMessage(testContext.startTest());
        return testStateDto;
    }

    public TestStateDto submitAnswer(TestResultDto testResultDto, int id) {
        TestContext testContext = testContextManager.getTestContext(id);
        TestEntity test = getById(testResultDto.getTestId());
        TestStateDto testStateDto = new TestStateDto();
        if(testContext == null) {
            testStateDto.setMessage(Constants.SUBMIT_TEST_NOT_STARTED);
            return testStateDto;
        }
        testStateDto.setMessage(testContext.submitAnswer());
        if(testStateDto.getMessage() != Constants.SUBMIT_TEST_ENDED) {
            testStateDto.setTestResult(this.testResultService.createTestResult(testResultDto, test));
        }
        return testStateDto;
    }

    public TestStateDto endTest(int id) {
        TestContext testContext = testContextManager.getTestContext(id);
        TestStateDto testStateDto = new TestStateDto();
        if(testContext == null) {
            testStateDto.setMessage(Constants.SUBMIT_TEST_NOT_STARTED);
            return testStateDto;
        }
        testStateDto.setMessage(testContext.endTest());
        return testStateDto;
    }
}
