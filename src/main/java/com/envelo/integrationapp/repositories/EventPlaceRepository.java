package com.envelo.integrationapp.repositories;

import com.envelo.integrationapp.model.entities.EventPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPlaceRepository extends JpaRepository<EventPlace, Long> {
}
