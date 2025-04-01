package com.f_rafael.gestionclientes.services;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Service("jetMailService")
public class JetMailService implements EmailService{

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void sendEmail(String asunto, List<String> to, String body) {

        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient(System.getenv("14ec4efb63a6524ed0b1b1aca9d98a96"), System.getenv("009b37e6f647aa9c9f5aecc7d8ca9dd7"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "fraq86@gmail.com")
                                        .put("Name", "Rafael Alvarez"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", to.get(0))
                                                ))
                                .put(Emailv31.Message.SUBJECT, asunto)
                                .put(Emailv31.Message.TEXTPART, body)
                                .put(Emailv31.Message.HTMLPART, body)));
        try {
            response = client.post(request);
        } catch (MailjetException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getStatus());
        System.out.println(response.getData());

    }

    @Override
    public void enviarEmailDeBienvenida(String asunto, List<String> to, String nombre) {

        Context context = new Context();
        context.setVariable("nombre", "Rafael");
        String mensajeHtml = templateEngine.process("email",context);
        sendEmail(asunto,to, mensajeHtml);

    }
}
