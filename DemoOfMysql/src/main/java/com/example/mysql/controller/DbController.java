package com.example.mysql.controller;

import com.example.mysql.model.User;
import com.example.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/mysql")
public class DbController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/getUser")
    public User getAllUsers(@RequestParam String mail) {
        return userRepository.findByEmail(mail);
    }

}
