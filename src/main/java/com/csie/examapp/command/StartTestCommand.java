package com.csie.examapp.command;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.csie.examapp.entities.TestEntity;

public class StartTestCommand implements StudentCommand {

    @Override
    public String execute(TestEntity test, int studentId) {

        LocalDateTime currentTime = LocalDateTime.now();
        long minutesElapsed = ChronoUnit.MINUTES.between(test.getStartTime(), currentTime);
        
        if (minutesElapsed <= test.getTestDurationMinutes()) {
            return("Test started successfully.");
        } else {
            return("Not within the allowed time window to start the test.");
        }
    }
}
