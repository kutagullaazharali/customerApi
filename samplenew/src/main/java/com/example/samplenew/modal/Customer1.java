package com.example.samplenew.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public Customer1(String name, String password, String username) {
        this.name = name;
        this.password = password;
        this.username = username;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAddress() {
        return address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        // Accessing username to ensure it's read
        return username;
    }
}
