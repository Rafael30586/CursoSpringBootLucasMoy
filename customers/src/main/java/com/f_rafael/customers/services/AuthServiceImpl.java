package com.f_rafael.customers.services;

import com.f_rafael.customers.entities.User;
import com.f_rafael.customers.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    public static final String SECRET_KEY = "4r4urfrfh";

    public User login(String email, String password){
        String hashPassword = Hashing.sha256()
                .hashString(password + SECRET_KEY, StandardCharsets.UTF_8)
                .toString();

        List<User> result = userRepository.findByEmailAndPassword(email, hashPassword);

        if(result.isEmpty()){
            return null;

        }else {
            return result.get(0);
        }

    }


}
