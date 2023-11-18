package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.entites.Avis;
import fanetech.tech.fbackend.entites.User;
import fanetech.tech.fbackend.repository.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AvisService {

    private final AvisRepository avisRepository;

    public  void creer(Avis avis){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        avis.setUser(user);
        this.avisRepository.save(avis);
    }

}
