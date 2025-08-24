package com.example.samplenew.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samplenew.modal.Customer1;

public interface CustomerRepository extends JpaRepository<Customer1, Long> {
}
