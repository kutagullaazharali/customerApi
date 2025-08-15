package com.example.samplenew.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.samplenew.modal.Customer1;
import com.example.samplenew.service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // GET all customers
    @GetMapping
    public List<Customer1> getAllCustomers() {
        List<Customer1> customers = customerService.getAllCustomers();
        customers.forEach(cusomer-> System.out.println(cusomer+"Customer Details"));
        return customerService.getAllCustomers();
    }

    // GET customer by ID
    @GetMapping("/{id}")
    public Customer1 getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    //GET customer by email
    @GetMapping("email/{email}")
    public Customer1 getCustomerByEmail(@PathVariable String email){
        return customerService.getCustomerByEmail(email);
    }
     @GetMapping("name/{name}")
    public Customer1 getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }
    // POST create new customer
    @PostMapping
    public Customer1 createCustomer(@RequestBody Customer1 customer) {
        return customerService.createCustomer(customer);
    }
    @DeleteMapping("/{id}")
    public Customer1 deleteCustomer(@PathVariable Long id) {
        // customerService.getCustomerById(id);
       return customerService.deleteCustomer(id);
    }
}
