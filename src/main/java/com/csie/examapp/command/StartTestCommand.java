package com.csie.examapp.command;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.utils.Constants;

public class StartTestCommand implements StudentCommand {

    @Override
    public String execute(TestEntity test, int studentId) {

        LocalDateTime currentTime = LocalDateTime.now();
        long minutesElapsed = ChronoUnit.MINUTES.between(test.getStartTime(), currentTime);
        
        if (minutesElapsed <= test.getTestDurationMinutes()) {
            if(studentId == -1) {
                return(Constants.START_TEST_COMMAND);
            } else {
                int minutesRemaining = test.getTestDurationMinutes() - (int)minutesElapsed;
                return(Constants.TEST_FOR_STUDENT_COMMAND + test.getId() + Constants.TEST_FOR_STUDENT + studentId + Constants.TEST_MINUTES_LEFT + minutesRemaining);
            }
        } else {
            return(Constants.TEST_NOT_IN_TIME_WINDOW);
        }
    }
}
