package com.example.seawise.security.chain_processor;

import com.example.seawise.logic.buisness.destination.domain.Destination;
import com.example.seawise.logic.buisness.ship.domain.Ship;
import com.example.seawise.security.blockchain.Block;
import com.example.seawise.security.blockchain.Chain;
import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Getter
public class BlockRequest {

    private Chain chain;
    private String hash;
    private String previousHash;
    private Ship ship;
    private Destination destination;
    private LocalDateTime timestamp;
    private Block block;

    public BlockRequest(Chain chain, String hash, String previousHash, Ship ship, Destination destination, LocalDateTime timestamp) {
        this.chain = chain;
        this.previousHash = findLastHash();
        this.ship = ship;
        this.destination = destination;
        this.timestamp = timestamp;
        this.hash = generateHash();
    }

    private String findLastHash() {
        return chain.getBlockList()
                .get(chain.getBlockList().size()-1)
                .getPreviousHash();
    }

    private String generateHash() {
        String data = previousHash +
                ship.toString() +
                destination.toString() +
                timestamp.toString();

        MessageDigest digest;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        for(byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

}
