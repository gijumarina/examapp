package com.csie.examapp.command;

import java.util.List;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.dto.TestAnswerDto;
import com.csie.examapp.utils.Constants;

public class SubmitAnswersCommand implements StudentCommand {
    private List<TestAnswerDto> answers;

    public SubmitAnswersCommand(List<TestAnswerDto> answers) {
        this.answers = answers;
    }

    @Override
    public String execute(TestEntity test, int studentId) {
        return(Constants.SUBMIT_ANSWERS_FOR_TEST + test.getId() + Constants.SUBMIT_ANSWERS_FOR_STUDENT + studentId);
    }
}
