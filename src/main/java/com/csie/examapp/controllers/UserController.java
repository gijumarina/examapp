package com.csie.examapp.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csie.examapp.dto.UserDto;
import com.csie.examapp.dto.AuthDto;
import com.csie.examapp.entities.UserEntity;
import com.csie.examapp.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getUsers() {
        return this.userService.findAll();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserDto userDto) {
        return this.userService.createUser(userDto);
    }

    @PostMapping("/login")
    public Set<String> loginUser(@RequestBody AuthDto authDto) {
        return this.userService.userLogIn(authDto);
    }

    @PostMapping("/logOut")
    public Set<String> logOutUser(@RequestBody String eMail) {
        return this.userService.userLogOut(eMail);
    }
}
