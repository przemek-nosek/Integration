package com.envelo.integrationapp.repositories;

import com.envelo.integrationapp.model.entities.EventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventParticipantRepository extends JpaRepository<EventParticipant, Long> {
}
