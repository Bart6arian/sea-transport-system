package com.example.seawise.security.mapper;

import com.example.seawise.security.blockchain.database.DatabaseUnit;
import com.example.seawise.security.dto.DbUnitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbUnitMapper {

    private final BlockchainMapper chainMapper;

    public DbUnitDto mapToDto(final DatabaseUnit unit) {
        return new DbUnitDto(
                unit.getUnitHash(),
                chainMapper.mapToChainDto(unit.getChain().getBlockList())
        );
    }
}
