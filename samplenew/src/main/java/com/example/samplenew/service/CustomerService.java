package com.example.samplenew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.samplenew.exception.ResourceNotFoundException;
import com.example.samplenew.modal.Customer1;
import com.example.samplenew.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Get all customers
    public List<Customer1> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Customer1 getCustomerById(Long id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found " ));
    }

    public Customer1 getCustomerByEmail(String email) {
        if(email == null || email.isEmpty()) {
            throw new ResourceNotFoundException("Customer email cannot be null or empty or not found" + email);
        }
        return null;
        // return customerRepository.findAll().stream()
        // .filter(customer -> {
        //     String customerEmail = customer.getEmail();
        //     return customerEmail != null && customerEmail.equals(email);
        // })
        // .findFirst()
        // .orElseThrow( () -> new ResourceNotFoundException("by this email none of the customers are exists") ); 
    }
    public Customer1 getCustomerByName(String name){
        if(name==null || name.isEmpty()){
            throw new ResourceNotFoundException("by this name user is not exits");
        }
        Customer1 customer = customerRepository.findAllByName(name);
        if(customer == null){
            throw new ResourceNotFoundException("by this name user is not exits in the system");
        }
        else
        {
            return customer;
        }
    }

    // Create a new customer
    public Customer1 createCustomer(Customer1 customer) {
        return customerRepository.save(customer);
    }
    public List<Customer1> CreateAllCustomers(List<Customer1> customer){
        return customerRepository.saveAll(customer);
    }
    public Customer1 deleteCustomer(long id) {
        Customer1 customer = getCustomerById(id);
        if (customer == null) {
            // throw new RuntimeException("Customer not found with id " + id);
            System.out.println("Customer not found with id or you doesn't to delete this id" + id);
           throw new ResourceNotFoundException("Customer not found with id " + id); 
        }
        customerRepository.delete(customer);
        return customer;
    }
}