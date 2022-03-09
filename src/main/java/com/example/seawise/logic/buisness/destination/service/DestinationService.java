package com.example.seawise.logic.buisness.destination.service;

import com.example.seawise.logic.buisness.destination.domain.Destination;
import com.example.seawise.logic.buisness.destination.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository repository;

    public Destination saveNewDestination(final Destination destination) {
        return repository.save(destination);
    }

    public Destination findDestinationById(final Long id) {
        return repository.findDestinationById(id);
    }

    public boolean checkIfDestinationOfGivenIdExists(final Long id) {
        return repository.existsById(id);
    }

    public void deleteById(final Long id) {
        repository.deleteById(id);
    }

    public List<Destination> findAll() {
        return (List<Destination>) repository.findAll();
    }
}
