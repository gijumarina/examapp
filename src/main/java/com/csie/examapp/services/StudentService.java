package com.csie.examapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.repositories.StudentRepository;
import com.csie.examapp.utils.Constants;

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
        return this.studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND + id));
    }

    public StudentEntity getByEmail(String eMail) {
        List<StudentEntity> students = this.studentRepository.findByEMail(eMail);
        if(students.size() != 0) {
            return students.get(0);
        } else {
            return new StudentEntity();
        }
    }

    public StudentEntity createStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }
}
