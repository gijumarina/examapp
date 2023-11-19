package com.csie.examapp.factory;

import com.csie.examapp.dto.UserDto;
import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.entities.TeacherEntity;
import com.csie.examapp.entities.UserEntity;

public class UserFactory {
    public UserEntity createUser(UserDto userDto) {
        switch (userDto.getUserType().toLowerCase()) {
            case "student":
                return new StudentEntity(userDto.getFirstName(), userDto.getLastName(), userDto.getAge(),
                        userDto.getCNP(), userDto.getEMail(), 1);
            case "teacher":
                return new TeacherEntity(userDto.getFirstName(), userDto.getLastName(), userDto.getAge(),
                        userDto.getCNP(), userDto.getEMail(), "mate");
            default:
                throw new IllegalArgumentException("Invalid userType: " + userDto.getUserType());
        }
    }
}
