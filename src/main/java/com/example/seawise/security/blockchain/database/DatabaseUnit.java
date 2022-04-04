package com.example.seawise.security.blockchain.database;

import com.example.seawise.security.blockchain.Chain;
import com.example.seawise.security.exceptions.DatabaseUnitInterruptionWarning;
import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class DatabaseUnit {

    private Long id;
    private String unitHash;
    private Chain chain;
    private LocalDateTime timestamp;

    public DatabaseUnit(Long id, Chain chain, LocalDateTime timestamp) {
        this.id = id;
        this.chain = chain;
        this.timestamp = timestamp;
        this.unitHash = generateHash();
    }

    //generate hash by MD5 algorithm, and using octal system as hash
    private String generateHash() {
        String unitData =
                id.toString()+ chain.toString() +
                timestamp.hashCode();

        MessageDigest digest;
        byte[] bytes = null;

        try {
            digest = MessageDigest.getInstance("MD5");
            bytes = digest.digest(unitData.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        for(byte b : bytes) {
            builder.append(String.format("%02o", b));
        }
        return builder.toString();
    }

    public boolean keyUnitVerifier(String key) throws DatabaseUnitInterruptionWarning {
        if(Objects.equals(key, unitHash)) {
            return true;
        } else
            throw new DatabaseUnitInterruptionWarning("Interruption in " +
                    "database unit of given blockchain");
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
