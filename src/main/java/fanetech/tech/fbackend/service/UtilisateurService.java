package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.entites.Role;
import fanetech.tech.fbackend.entites.User;
import fanetech.tech.fbackend.entites.Validation;
import fanetech.tech.fbackend.enums.TypeDeRole;
import fanetech.tech.fbackend.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurService implements UserDetailsService {

    private UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private ValidationService validationService;

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

         User userCreate = this.utilisateurRepository.save(user);

         this.validationService.enregistrer(userCreate);

    }

    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw new RuntimeException("Your code expired");
        }
        User user = this.utilisateurRepository.findById(validation.getUser().getId()).orElseThrow(() -> new RuntimeException("user unkwon"));
        user.setActif(true);
        this.utilisateurRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return  this.utilisateurRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
