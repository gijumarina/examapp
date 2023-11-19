package com.csie.examapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.repositories.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> findAll() {
        List<StudentEntity> students = this.studentRepository.findAll();
        return students;
    }

    public StudentEntity createStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }
}
