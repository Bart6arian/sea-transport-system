package com.example.seawise.security.blockchain;

import com.example.seawise.security.exceptions.BlockchainInterruptionException;
import com.example.seawise.security.exceptions.IllegalBlockchainCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Chain {

    private Long id;
    private List<Block> blockList;

    public void addToChain(Block block) throws IllegalBlockchainCondition {
        if(isPreviousHashCorrect(block)) {
            blockList.add(block);
        } else
            throw new IllegalBlockchainCondition();
    }

    public void removeFromChain(Block block) throws BlockchainInterruptionException {
        if(verifyPreviousBlock(block)) {
            blockList.remove(block);
        } else
            throw new BlockchainInterruptionException();
    }

    //verify hash from pre-last block
    private boolean verifyPreviousBlock(Block block) throws BlockchainInterruptionException {
        if(block.getPreviousHash().equals(blockList.get(blockList.size()-2).getHash())) {
            return true;
        } else
            throw new BlockchainInterruptionException();
    }

    //check if hash of last block corresponds with prefHash of given block
    private boolean isPreviousHashCorrect(Block block) throws IllegalBlockchainCondition {
        if(blockList.get(blockList.size()-1).getHash().equals(block.getPreviousHash())) {
            return true;
        } else
            throw new IllegalBlockchainCondition();
    }

}
