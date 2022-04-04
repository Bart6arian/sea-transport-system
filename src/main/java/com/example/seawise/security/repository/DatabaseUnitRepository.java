package com.example.seawise.security.repository;

import com.example.seawise.security.blockchain.Chain;
import com.example.seawise.security.blockchain.DatabaseUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseUnitRepository extends CrudRepository<DatabaseUnit, String> {
    DatabaseUnit findByUnitHash(String theHash);
}
