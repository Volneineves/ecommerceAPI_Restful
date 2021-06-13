package com.residencia.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    //    @RequestMapping(path = "/email-send", method = RequestMethod.GET)
    public String sendMail(String emailUsuario, String pedido, String nome) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(pedido);
        message.setTo(emailUsuario);
        message.setSubject("Sua compra foi finalizada, " + nome);
        message.setFrom("springtestepet@gmail.com");

        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}