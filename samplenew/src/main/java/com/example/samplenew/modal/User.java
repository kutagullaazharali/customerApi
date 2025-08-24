package com.example.samplenew.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor              // ✅ generates a no-arg constructor (required by JPA)
@Table(name = "users")          // ✅ use plural to avoid conflict with SQL reserved word
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;          // ✅ best practice: use 'id' instead of 'user_id'

    private String username;
    private String password;
    private String email;

    // convenience constructor
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
