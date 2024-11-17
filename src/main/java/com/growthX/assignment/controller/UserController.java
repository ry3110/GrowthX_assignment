package com.growthX.assignment.controller;

import com.growthX.assignment.model.User;
import com.growthX.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Implement login logic to generate JWT token
        return "JWT Token"; // For now, return a dummy string
    }

    @PostMapping("/upload")
    public String uploadAssignment() {
        return "Assignment uploaded successfully!";
    }
}

