package com.csie.examapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csie.examapp.entities.TeacherEntity;
import com.csie.examapp.repositories.TeacherRepository;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    private TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherEntity> findAll() {
        List<TeacherEntity> teachers = this.teacherRepository.findAll();
        return teachers;
    }

    public TeacherEntity createTeacher(TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }
}
