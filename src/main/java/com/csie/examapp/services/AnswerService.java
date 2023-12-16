package com.csie.examapp.services;

import org.springframework.stereotype.Service;

import com.csie.examapp.repositories.AnswerRepository;
import com.csie.examapp.entities.AnswerEntity;
import com.csie.examapp.entities.QuestionEntity;
import com.csie.examapp.dto.AnswerDto;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    private AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public AnswerEntity createAnswer(AnswerDto answerDto, QuestionEntity question) {
        AnswerEntity answer = new AnswerEntity();
        answer.setText(answerDto.getText());
        answer.setCorrect(answerDto.isCorrect());
        answer.setQuestion(question);
        return this.answerRepository.save(answer);
    }
}