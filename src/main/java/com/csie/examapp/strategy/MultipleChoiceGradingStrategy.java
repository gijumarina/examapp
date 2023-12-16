package com.csie.examapp.strategy;

import java.util.List;

import com.csie.examapp.entities.QuestionEntity;
import com.csie.examapp.entities.AnswerEntity;

public class MultipleChoiceGradingStrategy implements GradingStrategy {
    @Override
    public int calculateScore(QuestionEntity question, List<Integer> selectedAnswerIds) {
        for(AnswerEntity answer : question.getAnswers()) {
            if (selectedAnswerIds.contains(answer.getId()) && answer.isCorrect()) {
                return question.getScore();
            }
        }
        return 0;
    }
}