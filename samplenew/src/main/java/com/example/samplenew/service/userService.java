package com.example.samplenew.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.samplenew.modal.User;
import com.example.samplenew.repository.UserRepository;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String findUser(String username, String password) {
        User user = userRepository.findByEmailAndPassword(username, password);
        return (user != null) ? "Login Successful" : "Invalid Credentials";
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
