package com.example.seawise.security.service;

import com.example.seawise.security.dto.DbUnitDto;
import com.example.seawise.security.mapper.DbUnitMapper;
import com.example.seawise.security.repository.DatabaseUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbUnitService {

    private final DatabaseUnitRepository unitRepository;
    private final DbUnitMapper dbUnitMapper;

    public DbUnitDto findDbUnitByHash(final String hash) {
        return dbUnitMapper.mapToDto(unitRepository.findByUnitHash(hash));
    }
}
