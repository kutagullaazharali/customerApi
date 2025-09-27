package com.example.samplenew.modal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product")  // best practice to use @Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;

    private String name;
    private double price;
    private String description;
    private String image;
    private int quantity;
    private double weight;
}
