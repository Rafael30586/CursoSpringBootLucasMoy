package com.f_rafael.gestionclientes.services;

import java.util.List;

public interface EmailService {

    void sendEmail(String asunto, List<String> to, String body);

    void enviarEmailDeBienvenida(String asunto, List<String> to, String nombre);
}
