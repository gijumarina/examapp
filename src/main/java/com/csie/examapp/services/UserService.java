package com.csie.examapp.services;

import com.csie.examapp.dto.UserDto;
import com.csie.examapp.dto.AuthDto;
import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.entities.TeacherEntity;
import com.csie.examapp.entities.UserEntity;
import com.csie.examapp.entities.UserEnum;
import com.csie.examapp.factory.UserFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserService {

    private StudentService studentService;
    private TeacherService teacherService;

    private UserService(StudentService studentService, TeacherService teacherService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        List<TeacherEntity> teachers = this.teacherService.findAll();
        List<StudentEntity> students = this.studentService.findAll();

        for (TeacherEntity teacherEntity : teachers) {
            UserEntity user = teacherEntity;
            users.add(user);
        }

        for (StudentEntity student : students) {
            UserEntity user = student;
            users.add(user);
        }
        return users;
    }

    public UserEntity createUser(UserDto userDto) {
        UserFactory userFactory = new UserFactory();
        userDto.setPassword(BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt()));
        UserEntity userEntity = userDto.getUserType() == UserEnum.STUDENT
                ? studentService.createStudent((StudentEntity) userFactory.createUser(userDto))
                : teacherService.createTeacher((TeacherEntity) userFactory.createUser(userDto));
        return userEntity;
    }

    public boolean userLogIn (AuthDto authDto) {
        UserEntity userEntity = authDto.getType() == UserEnum.STUDENT ?
            studentService.getByEmail(authDto.getEMail()) : teacherService.getByEmail(authDto.getEMail());
        return BCrypt.checkpw(authDto.getPassword(), userEntity.getPassword());
    }
}
