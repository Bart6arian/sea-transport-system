package com.example.seawise.security.blockchain;

import com.example.seawise.logic.buisness.destination.domain.Destination;
import com.example.seawise.logic.buisness.ship.domain.Ship;
import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Getter
public class Block {

    private String hash;
    private String previousHash;
    private Ship ship;
    private Destination destination;
    private LocalDateTime timestamp;
    private int nonce;

    public Block(String previousHash, Ship ship, Destination destination, LocalDateTime timestamp) {
        this.previousHash = previousHash;
        this.ship = ship;
        this.destination = destination;
        this.timestamp = timestamp;
        this.hash = calculateBlocksHash();
    }

    private String calculateBlocksHash() {
        String data = previousHash +
                ship.toString() +
                destination.toString() +
                timestamp.toString();

        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuffer buffer = new StringBuffer();
        for(byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public String mineTheBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while(!hash.substring(0, prefix).equals(prefixString)) {
            nonce++;
            hash = calculateBlocksHash();
        }
        return hash;
    }
}
