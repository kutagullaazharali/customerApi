package com.example.samplenew.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer1
{ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String username;
    private String password;
    private String email;
    private String role;
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
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.username = username;
    }
}
