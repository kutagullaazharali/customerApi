package com.example.samplenew.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.samplenew.service.userService;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.samplenew.modal.User;

@RestController
@RequestMapping("/api/login")
public class userController{

    @Autowired
    private userService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getallusers();
    }
     @GetMapping("/{username}")
    public String loginUser(@RequestParam String username) {
       return userService.finsUser(username);
    }
}