package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.entites.Avis;
import fanetech.tech.fbackend.repository.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AvisService {

    private final AvisRepository avisRepository;

    public  void creer(Avis avis){
        this.avisRepository.save(avis);
    }

}
