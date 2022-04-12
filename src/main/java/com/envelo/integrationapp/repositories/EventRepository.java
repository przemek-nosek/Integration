package com.envelo.integrationapp.repositories;

import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.enums.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByEventStatus(EventStatus eventStatus);
}
