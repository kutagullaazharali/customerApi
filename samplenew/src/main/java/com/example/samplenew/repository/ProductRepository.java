package com.example.samplenew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.samplenew.modal.Product;

@Repository
public interface  ProductRepository extends  JpaRepository<Product, Integer>{

}
