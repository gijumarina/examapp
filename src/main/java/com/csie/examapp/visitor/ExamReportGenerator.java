package com.csie.examapp.visitor;

import com.csie.examapp.entities.QuestionEntity;
import com.csie.examapp.entities.QuestionType;
import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.dto.ExamReportDto;

public class ExamReportGenerator implements ExamReportVisitor {

    @Override
    public ExamReportDto visit(TestEntity testEntity) {
        int noOfQuestions = testEntity.getQuestions().size();
        int noOfMultipleChoice = 0;
        int noOfMultipleAnswer = 0;
        int noOfOpenAnswers = 0;
        for(QuestionEntity question : testEntity.getQuestions()) {
            switch (question.getType()) {
                case MULTIPLE_ANSWERS:
                    noOfMultipleAnswer++;
                    break;
                case OPEN_ANSWER:
                    noOfOpenAnswers++;
                    break;
                case MULTIPLE_CHOICE:
                    noOfMultipleChoice++;
                    break;
                default:
                    break;
            }
        }

        ExamReportDto examReportDto = new ExamReportDto();
        examReportDto.setNoOfQuestions(noOfQuestions);
        examReportDto.setNoOfMultipleChoice(noOfMultipleChoice);
        examReportDto.setNoOfMultipleAnswer(noOfMultipleAnswer);
        examReportDto.setNoOfOpenAnswers(noOfOpenAnswers);

        return examReportDto;
    }
}
