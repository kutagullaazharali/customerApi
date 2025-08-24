package com.example.samplenew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samplenew.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {
 List<User> findAllByEmail(String email);
  List<User> findAllByusername(String username);


}
