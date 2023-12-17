package com.csie.examapp.services;

import java.util.List;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.entities.TestResultEntity;
import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.entities.QuestionEntity;
import com.csie.examapp.dto.TestResultDto;
import com.csie.examapp.dto.TestAnswerDto;
import com.csie.examapp.repositories.TestResultRepository;
import com.csie.examapp.strategy.GradingStrategy;
import com.csie.examapp.strategy.MultipleChoiceGradingStrategy;
import com.csie.examapp.strategy.OpenAnswerGradingStrategy;
import com.csie.examapp.strategy.MultipleAnswersGradingStrategy;

import java.lang.UnsupportedOperationException;

import org.springframework.stereotype.Service;

@Service
public class TestResultService {
    
    private TestResultRepository testResultRepository;
    private StudentService studentService;

    private TestResultService(TestResultRepository testResultRepository, StudentService studentService) {
        this.testResultRepository = testResultRepository;
        this.studentService = studentService;
    }

    public TestResultEntity createTestResult(TestResultDto testResultDto, TestEntity test) {
        TestResultEntity testResult = new TestResultEntity();
        StudentEntity student = this.studentService.getById(testResultDto.getStudentId());
        testResult.setStudent(student);
        testResult.setTest(test);
        testResult.setResult(getResult(test, testResultDto.getTestAnswers()));
        return this.testResultRepository.save(testResult);
    }

    private int getResult(TestEntity test, List<TestAnswerDto> testsAnswerDto) {
        GradingStrategy gradingStrategy;
        int score = 1;

        for(QuestionEntity question : test.getQuestions()) {
            for(TestAnswerDto testAnswerDto : testsAnswerDto) {
                if(testAnswerDto.getQuestionId() == question.getId()) {
                    switch(question.getType()) {
                        case MULTIPLE_CHOICE:
                            gradingStrategy = new MultipleChoiceGradingStrategy();
                            break;
                        case OPEN_ANSWER:
                            gradingStrategy = new OpenAnswerGradingStrategy();
                            break;
                        case MULTIPLE_ANSWERS:
                            gradingStrategy = new MultipleAnswersGradingStrategy();
                            break;
                        default:
                            throw new UnsupportedOperationException("Unsupported question type: " + question.getType());
                    }

                    score += gradingStrategy.calculateScore(question, testAnswerDto.getAnswersIds());
                }
            }
        }

        return score;
    }
}