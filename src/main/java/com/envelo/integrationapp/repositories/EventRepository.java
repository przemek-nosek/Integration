package com.envelo.integrationapp.repositories;

import com.envelo.integrationapp.model.entities.Event;

import com.envelo.integrationapp.model.enums.EventRole;
import com.envelo.integrationapp.model.enums.EventStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


    @Query("select e from Event e, EventParticipant ep where ep.appUser.id=:id and ep.eventRole='HOST'")
    List<Event> findEventsByCreator(Long id);



    List<Event> findAllByEventStatus(EventStatus eventStatus);

}
