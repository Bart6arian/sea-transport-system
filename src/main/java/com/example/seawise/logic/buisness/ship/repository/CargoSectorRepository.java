package com.example.seawise.logic.buisness.ship.repository;

import com.example.seawise.logic.buisness.ship.domain.CargoSector;
import com.example.seawise.logic.buisness.ship.domain.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CargoSectorRepository extends CrudRepository<CargoSector, Long> {

    Set<CargoSector> findAllByShip(Ship ship);
}
