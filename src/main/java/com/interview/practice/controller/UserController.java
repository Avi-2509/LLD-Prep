package com.interview.practice.controller;

import com.interview.practice.component.model.User;
import com.interview.practice.component.model.components.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
public class UserController {

    @Autowired
    UserComponent userComponent;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody User user){
        userComponent.createUser(user);
        return "hi";
    }
}
