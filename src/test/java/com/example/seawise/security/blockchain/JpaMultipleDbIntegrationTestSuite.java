package com.example.seawise.security.blockchain;

import com.example.seawise.security.blockchain.database.DatabaseUnit;
import com.example.seawise.security.repository.ChainRepository;
import com.example.seawise.security.repository.DatabaseUnitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EnableTransactionManagement
public class JpaMultipleDbIntegrationTestSuite {

    @Autowired
    private DatabaseUnitRepository databaseUnitRepository;

    @Autowired
    private ChainRepository chainRepository;

    @Test
    @Transactional("unitEntityManager")
    public void shouldSaveNewDbUnitSimpleTest() {
        //given
        DatabaseUnit dbU = new DatabaseUnit(1L, null, LocalDateTime.now());
        DatabaseUnit save = databaseUnitRepository.save(dbU);
        assertEquals(1L, save.getId());
    }
}
