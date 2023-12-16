package com.csie.examapp.strategy;

import java.util.List;

import com.csie.examapp.entities.QuestionEntity;
import com.csie.examapp.entities.AnswerEntity;

public class MultipleAnswersGradingStrategy implements GradingStrategy {
    @Override
    public int calculateScore(QuestionEntity question, List<Integer> selectedAnswerIds) {
        int correctAnswersNumber = 0;
        int correctAnswersChecked = 0;
        int incorrectAnswersChecked = 0;

        for(AnswerEntity answer : question.getAnswers()) {
            if(answer.isCorrect()) {
                correctAnswersNumber++;
            }
            for(Integer answerId : selectedAnswerIds) {
                if(answerId == answer.getId()) {
                    if(answer.isCorrect()) {
                        correctAnswersChecked ++;
                    } else {
                        incorrectAnswersChecked++;
                    }
                }
            }
        }

        if(incorrectAnswersChecked == 0 && correctAnswersNumber == correctAnswersChecked) {
            return question.getScore();
        } else {
            int scorePerCorrectAnswer = question.getScore() / correctAnswersNumber;
            int totalScore = scorePerCorrectAnswer * correctAnswersChecked - scorePerCorrectAnswer * incorrectAnswersChecked;
            return totalScore > 0 ? totalScore : 0;

        }
    }
}