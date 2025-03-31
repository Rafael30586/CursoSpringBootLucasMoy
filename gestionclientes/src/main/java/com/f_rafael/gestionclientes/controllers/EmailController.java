package com.f_rafael.gestionclientes.controllers;

import com.f_rafael.gestionclientes.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmailController {

    @Autowired
    private EmailService service;

    @GetMapping("/api/email")
    public void sendEmail(){
        String asunto = "Gracias por registrarte";
        List<String> to = new ArrayList<>();
        to.add("fraq86@gmail.com");
        to.add("mariano@yahoo.com");
        String body = "Hola, gracias por registrarte";

        service.sendEmail(asunto, to ,body);

    }
}
