package com.example.seawise.security.repository;

import com.example.seawise.security.blockchain.database.DatabaseUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseUnitRepository extends CrudRepository<DatabaseUnit, String> {
    DatabaseUnit findByUnitHash(String theHash);
}
