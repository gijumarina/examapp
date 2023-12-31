package com.csie.examapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.csie.examapp.entities.TeacherEntity;
import com.csie.examapp.repositories.TeacherRepository;
import com.csie.examapp.utils.Constants;

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

    public TeacherEntity getById(int id) {
        return this.teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND + id));
    }

    public TeacherEntity getByEmail(String eMail) {
        List<TeacherEntity> teachers = this.teacherRepository.findByEMail(eMail);
        if(teachers.size() != 0) {
            return teachers.get(0);
        } else {
            return new TeacherEntity();
        }
    }

    public TeacherEntity createTeacher(TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }
}
