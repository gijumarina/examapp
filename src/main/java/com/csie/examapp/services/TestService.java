package com.csie.examapp.services;

import java.util.ArrayList;
import java.util.List;

import com.csie.examapp.command.StudentCommand;
import com.csie.examapp.command.StartTestCommand;
import com.csie.examapp.command.SubmitAnswersCommand;
import com.csie.examapp.command.EndTestCommand;
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

import java.time.LocalDateTime;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    private QuestionService questionService;
    private TeacherService teacherService;
    private TestRepository testRepository;
    private TestResultService testResultService;
    private TestContextManager testContextManager;
    private List<StudentCommand> commandHistory = new ArrayList<>();
    
    private TestService(QuestionService questionService, TeacherService teacherService, TestRepository testRepository,
        TestResultService testResultService, TestContextManager testContextManager) {
        this.questionService = questionService;
        this.teacherService = teacherService;
        this.testRepository = testRepository;
        this.testResultService = testResultService;
        this.testContextManager = testContextManager;
    }

    public TestEntity getById(int id) {
        return this.testRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND + id));
    }

    public TestEntity createTest(TestDto testDto) {
        TestEntity test = new TestEntity();
        TeacherEntity teacher = teacherService.getById(testDto.getTeacherId());
        test.setTeacher(teacher);
        test.setGroupId(testDto.getGroupId());
        test.setMinRequired(testDto.getMinRequired());
        test.setStartTime(testDto.getStartTime());
        test.setTestDurationMinutes(testDto.getTestDurationMinutes());
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
        TestEntity test = getById(id);
        StudentCommand startTestCommand = new StartTestCommand();
        String resultCommand = executeCommand(startTestCommand, test, -1);
        testStateDto.setMessage(testStateDto.getMessage() + " " + resultCommand);
        return testStateDto;
    }

    public TestStateDto studentStartTest(int id, int studentId) {
        TestContext testContext = testContextManager.getTestContext(id);
        TestStateDto testStateDto = new TestStateDto();
        if(testContext == null) {
            testStateDto.setMessage("Test not started yet!");
        } else {
            if(testContext.isTestInProgress()) {
                TestEntity test = getById(id);
                StudentCommand startTestCommand = new StartTestCommand();
                String resultCommand = executeCommand(startTestCommand, test, studentId);
                testStateDto.setMessage(resultCommand);
            } else {
                testStateDto.setMessage(Constants.END_TEST_END);
            }
        }
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
        StudentCommand submitAnswersCommand = new SubmitAnswersCommand(testResultDto.getTestAnswers());
        String resultCommand = executeCommand(submitAnswersCommand, test, testResultDto.getStudentId());
        testStateDto.setMessage(testStateDto.getMessage() + " " + resultCommand);
        return testStateDto;
    }

    public TestStateDto endTest(int id) {
        TestContext testContext = testContextManager.getTestContext(id);
        TestStateDto testStateDto = new TestStateDto();
        if(testContext == null) {
            testStateDto.setMessage(Constants.SUBMIT_TEST_NOT_STARTED);
            return testStateDto;
        }
        TestEntity test = getById(id);
        StudentCommand endTestCommand = new EndTestCommand();
        String resultCommand = executeCommand(endTestCommand, test, -1);
        testStateDto.setMessage(testContext.endTest() + " " + resultCommand);
        return testStateDto;
    }

    public TestStateDto studentEndTest(int id, int studentId) {
        TestContext testContext = testContextManager.getTestContext(id);
        TestStateDto testStateDto = new TestStateDto();
        if(testContext == null) {
            testStateDto.setMessage(Constants.SUBMIT_TEST_NOT_STARTED);
            return testStateDto;
        }
        TestEntity test = getById(id);
        StudentCommand endTestCommand = new EndTestCommand();
        String resultCommand = executeCommand(endTestCommand, test, studentId);
        testStateDto.setMessage(testContext.endTest() + " " + resultCommand);
        return testStateDto;
    }

    public String executeCommand(StudentCommand command, TestEntity test, int studentId) {
        String result = command.execute(test, studentId);
        commandHistory.add(command);
        return result;
    }

}
