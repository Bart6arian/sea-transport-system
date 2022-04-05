package com.example.seawise.security.service;

import com.example.seawise.security.blockchain.Block;
import com.example.seawise.security.blockchain.Chain;
import com.example.seawise.security.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChainService {

    private final ChainRepository chainRepository;

    public Chain findChainById(final Long id) {
        return chainRepository.findChainById(id);
    }

    public Block findGivenBlockByHash(final String hash) {
        List<Chain> all = chainRepository.findAll();
        return all.stream()
                .flatMap(c -> c.getBlockList().stream())
                .filter(b -> b.getHash().equals(hash))
                .findFirst()
                .orElseThrow();
    }
}
