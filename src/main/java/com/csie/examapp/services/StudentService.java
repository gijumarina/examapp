package com.csie.examapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.repositories.StudentRepository;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

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

    public StudentEntity getById(int id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Can not find student with id: " + id));
    }

    public StudentEntity createStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }
}
