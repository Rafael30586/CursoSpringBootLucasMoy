package com.f_rafael.customers.services;

import com.f_rafael.customers.entities.User;

import com.f_rafael.customers.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    public static final String SECRET_KEY = "4r4urfrfh";
    @Autowired
    UserRepository repository;

    public User getUser (Integer id){
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }


    public List<User> getAllUsers(){
        List<User> users = new ArrayList();

        Iterable<User> iterable = repository.findAll();
        for(User User:iterable){
            users.add(User);
        }
        return users;
    }


    public void removeUser( Integer id){
        repository.deleteById(id);
    }


    public void addUser(User user){

        String hashPassword = Hashing.sha256()
                .hashString(user.getPassword() + SECRET_KEY, StandardCharsets.UTF_8)
                .toString();
        user.setPassword(hashPassword);
        repository.save(user);
    }

    public void updateUser(User updateUser,Integer id){
        updateUser.setId(id);
        repository.save(updateUser);
    }

    public List<User> searchUser( String email, String address) {
        return repository.findByEmailOrAddress(email,address);
    }
}
