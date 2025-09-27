package com.example.samplenew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.samplenew.modal.Product;
import com.example.samplenew.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getproducts(){
        return productRepository.findAll();
    }
}
