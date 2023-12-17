package com.csie.examapp.factory;

import com.csie.examapp.dto.UserDto;
import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.entities.TeacherEntity;
import com.csie.examapp.entities.UserEntity;
import com.csie.examapp.utils.Constants;

public class UserFactory {
    public UserEntity createUser(UserDto userDto) {
        switch (userDto.getUserType()) {
            case STUDENT:
                return new StudentEntity(userDto.getFirstName(), userDto.getLastName(), userDto.getAge(),
                        userDto.getCNP(), userDto.getEMail(), userDto.getGroupId(), userDto.getPassword());
            case TEACHER:
                return new TeacherEntity(userDto.getFirstName(), userDto.getLastName(), userDto.getAge(),
                        userDto.getCNP(), userDto.getEMail(), userDto.getSubject(), userDto.getPassword());
            default:
                throw new IllegalArgumentException(Constants.INVALID_ARGUMENT_EXCEPTION + Constants.USER_TYPE_FIELD_NAME + userDto.getUserType());
        }
    }
}
