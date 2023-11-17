package fanetech.tech.fbackend.repository;

import fanetech.tech.fbackend.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
