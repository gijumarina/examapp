package com.csie.examapp.command;

import java.util.List;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.dto.TestAnswerDto;

public class SubmitAnswersCommand implements StudentCommand {
    private List<TestAnswerDto> answers;

    public SubmitAnswersCommand(List<TestAnswerDto> answers) {
        this.answers = answers;
    }

    @Override
    public String execute(TestEntity test, int studentId) {
        return("Answers submited for Test ID: " + test.getId() + ", Student ID: " + studentId);
    }
}
