package com.example.seawise.logic.buisness.ship.service;

import com.example.seawise.logic.buisness.ship.domain.CargoSector;
import com.example.seawise.logic.buisness.ship.domain.Ship;
import com.example.seawise.logic.buisness.ship.repository.CargoSectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CargoSectorService {

    private final CargoSectorRepository repository;

    public Set<CargoSector> findSectorOfGivenShip(final Ship ship) {
        return repository.findAllByShip(ship);
    }
}
