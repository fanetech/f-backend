package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.entites.Validation;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

     JavaMailSender javaMailSender;
    public void envoyer(Validation validation){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("louguefranck.20@gmail.com");
        message.setTo(validation.getUser().getEmail());
        message.setSubject("Votre code d'activation");

        String texte = String.format(
                "Bonjour %s, <br /> Votre code d'activation est %s",
                validation.getUser().getNom(),
                validation.getCode()
        );

        message.setText(texte);

        javaMailSender.send(message);

    }
}
