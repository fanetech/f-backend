package fanetech.tech.fbackend.controller;

import fanetech.tech.fbackend.dto.AuthentificationDTO;
import fanetech.tech.fbackend.entites.User;
import fanetech.tech.fbackend.security.JwtService;
import fanetech.tech.fbackend.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//@RequestMapping(consumes = "application/json")
public class UtilisateurController {

    private UtilisateurService utilisateurService;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @PostMapping(path = "inscription")
    @ResponseStatus(HttpStatus.CREATED)
    public void inscription(@RequestBody User user) {
        log.info("Inscription");
        System.out.println(user.getNom());
        this.utilisateurService.inscription(user);
    }

    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation){
        this.utilisateurService.activation(activation);

    }

    @PostMapping(path = "connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO){
       System.out.println(authentificationDTO);
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
        );

        if(authenticate.isAuthenticated()){
            return this.jwtService.generate(authentificationDTO.username());
        }
        System.out.println(authenticate.isAuthenticated());
        return null;
    }
}
