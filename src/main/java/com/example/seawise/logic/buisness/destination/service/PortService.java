package com.example.seawise.logic.buisness.destination.service;

import com.example.seawise.logic.buisness.destination.domain.Port;
import com.example.seawise.logic.buisness.destination.repository.PortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortService {

    private final PortRepository repository;

    public Port saveNewPort(final Port port) {
        return repository.save(port);
    }

    public Port findById(final Long id) {
        return repository.findPortById(id);
    }

    public void deletePortById(final Long id) {
        repository.deleteById(id);
    }

    public List<Port> findAllPorts() {
        return (List<Port>) repository.findAll();
    }
}
