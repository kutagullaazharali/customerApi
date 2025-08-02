package com.example.samplenew.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samplenew.modal.Customer1;

public interface CustomerRepository extends JpaRepository<Customer1, Long> {
 Customer1 findAllByName(String name);
}
