package com.example.seawise.security.mapper;

import com.example.seawise.logic.buisness.destination.mapper.DestinationMapper;
import com.example.seawise.logic.buisness.ship.mapper.ShipMapper;
import com.example.seawise.security.blockchain.Block;
import com.example.seawise.security.dto.BlockDto;
import com.example.seawise.security.dto.ChainDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlockchainMapper {

    private final ShipMapper shipMapper;
    private final DestinationMapper destinationMapper;

    public BlockDto mapToBlockDto(Block block) {
        return new BlockDto(
                block.getHash(),
                shipMapper.mapToShipDto(block.getShip()),
                destinationMapper.mapToDestinationDto(block.getDestination())
        );
    }

    public ChainDto mapToChainDto(List<Block> blocks) {
        return new ChainDto(
                blocks.stream()
                .map(this::mapToBlockDto)
                .collect(Collectors.toList()));
    }
}
