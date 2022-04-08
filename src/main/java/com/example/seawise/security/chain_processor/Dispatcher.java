package com.example.seawise.security.chain_processor;

import com.example.seawise.security.blockchain.Block;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Dispatcher {

    private BlockRequest newBlock;

    private boolean decision(List<Block> chain) {
        boolean result = false;

    }
}
