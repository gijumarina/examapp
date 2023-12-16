package com.csie.examapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.csie.examapp.repositories.QuestionRepository;
import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.dto.QuestionDto;
import com.csie.examapp.entities.QuestionEntity;

@Service
public class QuestionService {

    private AnswerService answerService;
    private QuestionRepository questionRepository;

    private QuestionService(AnswerService answerService, QuestionRepository questionRepository) {
        this.answerService = answerService;
        this.questionRepository = questionRepository;
    }

    public QuestionEntity createQuestion(QuestionDto questionDto, TestEntity test) {
        QuestionEntity question = new QuestionEntity();
        question.setText(questionDto.getText());
        question.setType(questionDto.getType());
        question.setTest(test);
        QuestionEntity newQuestion = questionRepository.save(question);
        return newQuestion;
    }
    
}
