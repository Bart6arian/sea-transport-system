package com.example.seawise.logic.buisness.cargo.service;

import com.example.seawise.logic.buisness.cargo.domain.Cargo;
import com.example.seawise.logic.buisness.cargo.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository repository;

    public List<Cargo> findAllCargos() {
        return repository.findAll();
    }

    public Optional<Cargo> findCargoByGivenId(final Long id) {
        return repository.findById(id);
    }

    public List<Cargo> orderCargoByValue() {
        return repository.findAllByDeclaredValueOrderByDeclaredValueContractedDesc();
    }

    public Cargo addNewCargo(Cargo cargo) {
        return repository.save(cargo);
    }

    public void deleteCargoById(final Long id) {
        repository.deleteById(id);
    }

    //only to check if it will be possible to get there and delete all
    private void superSecretMethod() {
        repository.deleteAll();
    }
}
