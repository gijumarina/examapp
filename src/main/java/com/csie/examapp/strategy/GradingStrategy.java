package com.csie.examapp.strategy;

import java.util.List;

import com.csie.examapp.entities.QuestionEntity;

public interface GradingStrategy {
    int calculateScore(QuestionEntity question, List<Integer> selectedAnswerIds);
}