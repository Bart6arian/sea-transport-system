package com.example.seawise.logic.buisness.ship.service;

import com.example.seawise.logic.buisness.ship.repository.ShipRepository;
import com.example.seawise.logic.buisness.ship.domain.Ship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipService {

    private final ShipRepository repository;

    public List<Ship> findAllShips() {
        return repository.findAll();
    }

    public Ship saveNewShip(final Ship ship) {
        return repository.save(ship);
    }

    public Optional<Ship> findByGivenId(final Long id) {
        return repository.findById(id);
    }

    public List<Ship> sortByWeightRaw() {
        return repository.findAllByWeightRawOrderByTypeWeightRawDesc();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
