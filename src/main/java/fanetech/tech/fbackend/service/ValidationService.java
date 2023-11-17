package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.entites.User;
import fanetech.tech.fbackend.entites.Validation;
import fanetech.tech.fbackend.repository.ValidationRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
@AllArgsConstructor
public class ValidationService {

    private ValidationRespository validationRespository;
    private NotificationService notificationService;

    public void enregistrer(User user){
        Validation validation = new Validation();
        validation.setUser(user);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = Instant.now();
        expiration = expiration.plus(10, ChronoUnit.MINUTES);
        validation.setExpiration(expiration);

        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);

        validation.setCode(code);
        this.validationRespository.save(validation);
        this.notificationService.envoyer(validation);
    }

    public Validation lireEnFonctionDuCode(String code){
        return this.validationRespository.findByCode(code).orElseThrow(()-> new RuntimeException("your validation code is incorect"));
    }
}
