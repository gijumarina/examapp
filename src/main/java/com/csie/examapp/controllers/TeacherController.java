package com.csie.examapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csie.examapp.entities.TeacherEntity;
import com.csie.examapp.services.TeacherService;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:5173/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{email}")
        public TeacherEntity getByMail(@PathVariable String email) {
            return teacherService.getByEmail(email);
        }
}