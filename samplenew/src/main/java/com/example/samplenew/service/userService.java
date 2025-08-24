package com.example.samplenew.service;
import java.util.List;

import com.example.samplenew.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.samplenew.modal.User;

@Service
public class userService {

    @Autowired
    private UserRepository UserRespository;

    public List<User> getallusers(){
        System.out.print("getall the user method was called");
        return UserRespository.findAll();
    }

    public String finsUser(String username){
        List<User> user=UserRespository.findAllByusername(username);
        if(user==null){
            return "unauth";
        }
        else
        {
            return "login successful";
        }
    }

}
