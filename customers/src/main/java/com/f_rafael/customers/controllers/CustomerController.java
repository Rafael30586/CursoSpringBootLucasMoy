package com.f_rafael.customers.controllers;

import com.f_rafael.customers.entities.Customer;
import com.f_rafael.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService service;


    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Integer id){
        return service.getCustomer(id);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @DeleteMapping("/customer/{id}")
    public void removeCustomer(@PathVariable Integer id){
        service.removeCustomer(id);
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }


    @PutMapping("/customer/{id}")
    public void updateCustomer(@RequestBody Customer updateCustomer, @PathVariable Integer id){
        service.updateCustomer(updateCustomer,id);
    }

    @GetMapping("/customer/search")
    public List<Customer> searchCustomer(@RequestParam(name = "email", required = false) String email,
                                         @RequestParam(name = "address", required = false) String address) {
       return service.searchCustomer(email,address);
    }
/*


    @GetMapping("/prueba")
    public void updateCustomer(){

    }

    @GetMapping("/prueba")
    public List<Customer> searchCustomer(){
        return null;
    }*/

}
