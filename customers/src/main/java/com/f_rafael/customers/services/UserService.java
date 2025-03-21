package com.f_rafael.customers.services;

import com.f_rafael.customers.entities.Customer;
import com.f_rafael.customers.entities.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    User getUser (Integer id);
    List<User> getAllUsers();
    void removeUser( Integer id);
    void addUser(User user);
    void updateUser(User updateUser, @PathVariable Integer id);
    List<User> searchUser( String email, String address);
}
