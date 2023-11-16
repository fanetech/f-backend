package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.entites.Role;
import fanetech.tech.fbackend.entites.User;
import fanetech.tech.fbackend.enums.TypeDeRole;
import fanetech.tech.fbackend.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public void inscription(User user){
        if(!user.getEmail().contains("@")){
            throw new RuntimeException("Votre mail est invalid");
        }
        if(!user.getEmail().contains(".")){
            throw new RuntimeException("Votre mail est invalid");
        }

        Optional<User> utilisateurOptional = this.utilisateurRepository.findByEmail(user.getEmail());
        if(utilisateurOptional.isPresent()){
            throw new RuntimeException("votre mail est deja utilisé");
        }
        String mdpCrypte = this.passwordEncoder.encode(user.getMdp());
        user.setMdp(mdpCrypte);
        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
        user.setRole(roleUtilisateur);
        this.utilisateurRepository.save(user);
    }
}
