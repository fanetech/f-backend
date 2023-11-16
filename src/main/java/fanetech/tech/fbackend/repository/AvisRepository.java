package fanetech.tech.fbackend.repository;

import fanetech.tech.fbackend.entites.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
}
