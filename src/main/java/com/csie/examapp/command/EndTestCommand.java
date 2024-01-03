package com.csie.examapp.command;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.utils.Constants;

public class EndTestCommand implements StudentCommand {
    @Override
    public String execute(TestEntity test, int studentId) {
        LocalDateTime currentTime = LocalDateTime.now();
        long minutesElapsed = ChronoUnit.MINUTES.between(test.getStartTime(), currentTime);
        
        if (minutesElapsed <= test.getTestDurationMinutes()) {
            if(studentId == -1) {
                return(Constants.END_TEST_COMMAND);
            } else {
            return(Constants.TEST_FOR_STUDENT_COMMAND + test.getId() + Constants.TEST_FOR_STUDENT_END + studentId);
            }
        } else {
            return(Constants.END_TEST_END);
        }
    }
}
