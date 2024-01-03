package com.csie.examapp.command;

import com.csie.examapp.entities.TestEntity;

public interface StudentCommand {
    String execute(TestEntity test, int studentId);
}