package com.example.samplenew.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer1
{ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String address;
    private String username;
    private String password;
    @Email(message="Email should be valid")
    private String email;
    private String role;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @NotBlank(message = "Name is required")
    private String name;


    // Constructors
    public Customer1() {}

    public Customer1(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer1(String address, String email, Long id, String name, String password, String role, String username) {
        this.address = address;
        this.email = email;
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.username = username;
    }
}
