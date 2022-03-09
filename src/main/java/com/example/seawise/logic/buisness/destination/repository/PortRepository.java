package com.example.seawise.logic.buisness.destination.repository;

import com.example.seawise.logic.buisness.destination.domain.Port;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortRepository extends CrudRepository<Port, Long> {

    Port findPortById(final Long id);
}
