package com.f_rafael.customers.controllers;

import com.f_rafael.customers.entities.Customer;
import com.f_rafael.customers.entities.User;
import com.f_rafael.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/customer/{id}")
    public User getUser(@PathVariable Integer id){
        return service.getCustomer(id);
    }

    @GetMapping("/customer")
    public List<User> getAllUsers(){
        return service.getAllCustomers();
    }

    @DeleteMapping("/customer/{id}")
    public void removeUser(@PathVariable Integer id){
        service.removeCustomer(id);
    }

    @PostMapping("/customer")
    public void addUser(@RequestBody User user){
        service.addCustomer(user);
    }


    @PutMapping("/customer/{id}")
    public void updateUser(@RequestBody User updateCustomer, @PathVariable Integer id){
        service.updateCustomer(updateCustomer,id);
    }

    @GetMapping("/customer/search")
    public List<User> searchUser(@RequestParam(name = "email", required = false) String email,
                                         @RequestParam(name = "address", required = false) String address) {
        return service.searchCustomer(email,address);
    }
}
