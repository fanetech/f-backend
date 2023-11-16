package fanetech.tech.fbackend.controller;

import fanetech.tech.fbackend.entites.User;
import fanetech.tech.fbackend.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//@RequestMapping(consumes = "application/json")
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    @PostMapping(path = "inscription")
    @ResponseStatus(HttpStatus.CREATED)
    public void inscription(@RequestBody User user) {
        log.info("Inscription");
        System.out.println(user.getNom());
        this.utilisateurService.inscription(user);
    }
}
