package com.example.samplenew.Controller;
import com.example.samplenew.modal.Product;
import com.example.samplenew.*;
import org.springframework.web.bind.annotation.RequestBody;  // ✅

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.samplenew.service.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@CrossOrigin(origins = "http://localhost:3000")


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public List<Product> GetProducts(){
        return productService.getproducts();
    }


    @GetMapping("/{name}")
    public List<Product> GetProductByName(@PathVariable("name") String name) {
        return productService.getproductsByName(name);
    }
    @PostMapping
    public Product CreateProduct(@RequestBody Product product) {
        System.out.println("Received product: " + product);
        return productService.CreateProduct(product);
    }
}
