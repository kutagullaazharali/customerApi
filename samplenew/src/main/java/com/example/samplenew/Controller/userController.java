package com.example.samplenew.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.samplenew.service.userService;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.samplenew.modal.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class userController{

    @Autowired
    private userService userService;

    @GetMapping("/login")
    public List<User> getAllUsers(){
        return userService.getallusers();
    }
     @GetMapping("/{username}")
    public String loginUser(@PathVariable String username) {
       return userService.finsUser(username);
    }

    @PostMapping("/user")
    public User SaveUser(@RequestBody User user) {
        return userService.saveUser(user);        
    }
    
}