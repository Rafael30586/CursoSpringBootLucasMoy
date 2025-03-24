package com.f_rafael.customers.services;

import com.f_rafael.customers.entities.User;



public interface AuthService {

    public User login(String email, String password);
}
