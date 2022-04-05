package com.example.seawise.security.service;

import com.example.seawise.security.blockchain.database.DatabaseUnit;
import com.example.seawise.security.repository.DatabaseUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbUnitService {

    private final DatabaseUnitRepository unitRepository;

    public DatabaseUnit findDbUnitByHash(final String hash) {
        return unitRepository.findByUnitHash(hash);
    }
}
