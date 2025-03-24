package com.f_rafael.customers.controllers;

import com.f_rafael.customers.dto.RequestLogin;
import com.f_rafael.customers.entities.User;
import com.f_rafael.customers.services.AuthService;
import com.f_rafael.customers.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public String login(@RequestBody RequestLogin request){
        String email = request.getEmail();
        String password = request.getPassword();
        User user = service.login(email,password);

        String token = JwtUtil.generateToken(user);

        return token;

    }
}
