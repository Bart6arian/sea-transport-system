package com.example.seawise.security.repository;

import com.example.seawise.security.blockchain.Chain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainRepository extends CrudRepository<Chain, Long> {
}
