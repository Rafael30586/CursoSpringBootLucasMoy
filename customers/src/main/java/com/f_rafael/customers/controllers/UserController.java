package com.f_rafael.customers.controllers;

import com.f_rafael.customers.entities.User;

import com.f_rafael.customers.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id){
        return service.getUser(id);
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public void removeUser(@PathVariable Integer id){
        service.removeUser(id);
    }

    @PostMapping("/user")
    public void register(@RequestBody User user){
        service.addUser(user);
    }


    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody User updateUser, @PathVariable Integer id){
        service.updateUser(updateUser,id);
    }

    @GetMapping("/user/search")
    public List<User> searchUser(@RequestParam(name = "email", required = false) String email,
                                         @RequestParam(name = "address", required = false) String address) {
        return service.searchUser(email,address);
    }
}
