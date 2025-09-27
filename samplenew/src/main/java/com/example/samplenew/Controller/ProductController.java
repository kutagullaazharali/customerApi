package com.example.samplenew.Controller;
import com.example.samplenew.modal.Product;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.samplenew.service.ProductService;
import java.util.List;
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

}
