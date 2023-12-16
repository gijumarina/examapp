package com.csie.examapp.strategy;

import java.util.List;

import com.csie.examapp.entities.QuestionEntity;

public class MultipleChoiceGradingStrategy implements GradingStrategy {
    @Override
    public int calculateScore(QuestionEntity question, List<Integer> selectedAnswerIds) {
        System.out.println("Multiple choice question: " + question.getId());
        return 0;
    }
}