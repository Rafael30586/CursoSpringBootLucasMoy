package com.f_rafael.gestionclientes.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private TemplateEngine templateEngine;


    @Override
    public void sendEmail(String asunto, List<String> to, String body) {

        String usuario = "fraq86@gmail.com";
        String password= "azufre86";

        Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.strattls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com"); //para que funcione con un correo de gmail
        props.put("mail.smtp.port","587"); //el puerto por el que va a enviar el email

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario ,password);
            }
        });

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to.get(0)));
            message.setSubject(asunto);
            message.setText(body);

            Transport.send(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void enviarEmailDeBienvenida(String asunto, List<String> to, String nombre) {
        Context context = new Context();
        context.setVariable("nombre", "Rafael");
        String mensajeHtml = templateEngine.process("email",context);
        sendEmail(asunto,to, mensajeHtml);

    }
}
