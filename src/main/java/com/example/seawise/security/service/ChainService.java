package com.example.seawise.security.service;

import com.example.seawise.security.blockchain.Block;
import com.example.seawise.security.blockchain.Chain;
import com.example.seawise.security.dto.BlockDto;
import com.example.seawise.security.dto.ChainDto;
import com.example.seawise.security.mapper.BlockchainMapper;
import com.example.seawise.security.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChainService {

    private final ChainRepository chainRepository;
    private final BlockchainMapper mapper;

    public ChainDto findChainById(final Long id) {
        return mapper.mapToChainDto(
                chainRepository
                        .findChainById(id)
                        .getBlockList());
    }

    public BlockDto findGivenBlockByHash(final String hash) {
        List<Chain> all = chainRepository.findAll();
        Block block = all.stream()
                .flatMap(c -> c.getBlockList().stream())
                .filter(b -> b.getHash().equals(hash))
                .findFirst()
                .orElseThrow();
        return mapper.mapToBlockDto(block);
    }
}
