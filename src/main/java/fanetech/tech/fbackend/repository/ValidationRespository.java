package fanetech.tech.fbackend.repository;

import fanetech.tech.fbackend.entites.Validation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ValidationRespository extends CrudRepository<Validation, Integer> {
    Optional<Validation> findByCode(String code);
}
