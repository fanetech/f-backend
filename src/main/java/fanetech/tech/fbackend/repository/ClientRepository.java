package fanetech.tech.fbackend.repository;

import fanetech.tech.fbackend.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
