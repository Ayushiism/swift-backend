package com.example.Swift_backend.controller;

import com.example.Swift_backend.model.User;
import com.example.Swift_backend.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userServiceImplementation.createUser(user);
    }
}
