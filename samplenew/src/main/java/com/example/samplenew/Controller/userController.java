package com.example.samplenew.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.samplenew.service.userService;   // ✅ Use uppercase class name
import com.example.samplenew.modal.User;
@CrossOrigin(origins ="http://localhost:3000")

@RestController
@RequestMapping("/api")
public class UserController {   // ✅ Class name uppercase
    @Autowired
    private userService UserService;   // ✅ Service name uppercase

    @GetMapping("/login")
    public List<User> getAllUsers() {
        return UserService.getAllUsers();   // ✅ Method name should also be camelCase
    }

    @GetMapping("/{username}/{password}")
    public String loginUs(@PathVariable String username, @PathVariable String password) {
        return UserService.findUser(username, password);   // ✅ method must exist in UserService
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return UserService.saveUser(user);        
    }
}
