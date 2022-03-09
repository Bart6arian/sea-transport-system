package com.example.seawise.logic.buisness.destination.repository;

import com.example.seawise.logic.buisness.destination.domain.Destination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, Long> {
    Destination findDestinationById(final Long id);
}
