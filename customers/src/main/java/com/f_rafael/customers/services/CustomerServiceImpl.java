package com.f_rafael.customers.services;


import com.f_rafael.customers.entities.Customer;
import com.f_rafael.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository repository;



    public Customer getCustomer (Integer id){
        Optional<Customer> customer = repository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }
        return null;
    }


    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList();

        Iterable<Customer> iterable = repository.findAll();
        for(Customer customer:iterable){
            customers.add(customer);
        }
        return customers;
    }


    public void removeCustomer( Integer id){
        repository.deleteById(id);
    }


    public void addCustomer( Customer customer){
        repository.save(customer);
    }



    public void updateCustomer(Customer updateCustomer,Integer id){
        updateCustomer.setId(id);
        repository.save(updateCustomer);
    }

    public List<Customer> searchCustomer( String email, String address) {
        return repository.findByEmailOrAddress(email,address);
    }
}
