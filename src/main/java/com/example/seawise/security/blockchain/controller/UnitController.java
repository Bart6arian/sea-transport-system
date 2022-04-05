package com.example.seawise.security.blockchain.controller;

import com.example.seawise.security.dto.BlockDto;
import com.example.seawise.security.dto.ChainDto;
import com.example.seawise.security.dto.DbUnitDto;
import com.example.seawise.security.mapper.BlockchainMapper;
import com.example.seawise.security.mapper.DbUnitMapper;
import com.example.seawise.security.service.ChainService;
import com.example.seawise.security.service.DbUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/response")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UnitController {

    private final DbUnitService dbUnitService;
    private final ChainService chainService;
    private final DbUnitMapper unitMapper;
    private final BlockchainMapper blockchainMapper;

    @GetMapping("/unit/{hash}")
    public DbUnitDto showUnitByItsHash(@PathVariable("hash") final String hash) {
        return unitMapper.mapToDto(dbUnitService.findDbUnitByHash(hash));
    }

    @GetMapping("/chain/{id}")
    public ChainDto findChainById(@PathVariable("id") final Long id) {
        return blockchainMapper.mapToChainDto(chainService.findChainById(id).getBlockList());
    }

    @GetMapping("/block/{hash}")
    public BlockDto showBlockByItsHash(@PathVariable("hash") final String hash) {
        return blockchainMapper.mapToBlockDto(chainService.findGivenBlockByHash(hash));
    }
}
