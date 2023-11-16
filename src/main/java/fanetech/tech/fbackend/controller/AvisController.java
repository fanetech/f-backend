package fanetech.tech.fbackend.controller;

import fanetech.tech.fbackend.entites.Avis;
import fanetech.tech.fbackend.service.AvisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("avis")
@AllArgsConstructor
public class AvisController {
    private final AvisService avisService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creer(@RequestBody Avis avis){
        this.avisService.creer(avis);
    }

}
