package com.example.seawise.logic.buisness.ship.repository;

import com.example.seawise.logic.buisness.ship.domain.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends CrudRepository<Ship, Long> {

    List<Ship> findAllByWeightRawOrderByTypeWeightRawDesc();
    List<Ship> findAll();
    Optional<Ship> findById(Long shipId);
    void deleteById(Long id);
}
