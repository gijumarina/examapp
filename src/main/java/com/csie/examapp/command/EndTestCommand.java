package com.csie.examapp.command;

import com.csie.examapp.entities.TestEntity;

public class EndTestCommand implements StudentCommand {
    @Override
    public String execute(TestEntity test, int studentId) {
        if(studentId == -1) {
            return("Test ended for all students!");
        } else {
        return("Test with id: " + test.getId() + ", ended for Student with id: " + studentId);
        }
    }
}
