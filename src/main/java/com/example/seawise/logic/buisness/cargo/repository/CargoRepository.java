package com.example.seawise.logic.buisness.cargo.repository;

import com.example.seawise.logic.buisness.cargo.domain.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {
    List<Cargo> findAll();
    List<Cargo> findAllByDeclaredValueOrderByDeclaredValueContractedDesc();
    Optional<Cargo> findById(Long id);
    void deleteById(Long id);
}
