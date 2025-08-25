package com.example.samplenew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samplenew.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {

     User findByEmailAndPassword(String email, String password);

}
