package com.f_rafael.Users.services;

import com.f_rafael.customers.entities.User;
import com.f_rafael.customers.entities.User;
import com.f_rafael.customers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl {

    @Autowired
    UserRepository repository;



    public User getUser (Integer id){
        Optional<User> User = repository.findById(id);
        if(User.isPresent()){
            return User.get();
        }
        return null;
    }


    public List<User> getAllUsers(){
        List<User> Users = new ArrayList();

        Iterable<User> iterable = repository.findAll();
        for(User User:iterable){
            Users.add(User);
        }
        return Users;
    }


    public void removeUser( Integer id){
        repository.deleteById(id);
    }


    public void addUser( User User){
        repository.save(User);
    }



    public void updateUser(User updateUser,Integer id){
        updateUser.setId(id);
        repository.save(updateUser);
    }

    public List<User> searchUser( String email, String address) {
        return repository.findByEmailOrAddress(email,address);
    }
}
