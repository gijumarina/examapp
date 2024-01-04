package com.csie.examapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csie.examapp.entities.StudentEntity;
import com.csie.examapp.services.StudentService;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{email}")
        public StudentEntity getByMail(@PathVariable String email) {
            return studentService.getByEmail(email);
        }
}