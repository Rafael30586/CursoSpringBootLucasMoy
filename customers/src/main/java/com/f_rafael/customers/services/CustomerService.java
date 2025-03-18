package com.f_rafael.customers.services;

import com.f_rafael.customers.entities.Customer;

import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public interface CustomerService {

    Customer getCustomer (Integer id);
    List<Customer> getAllCustomers();
    void removeCustomer( Integer id);
    void addCustomer( Customer customer);
    void updateCustomer( Customer updateCustomer, @PathVariable Integer id);
    List<Customer> searchCustomer( String email, String address);
}
